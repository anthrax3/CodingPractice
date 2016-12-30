package codeReview.divideAndConquer;


import java.util.ArrayList;
import java.util.Set;

/**
 * Created by wangdong on 5/23/16.
 */
public class BurstBalloons {

    public static int maxCoins1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }


        return burstHelper(nums, 0);

    }

    //Backtracking
    private static int burstHelper(int[] nums, int preSum) {
        int alreadyBursted = 0;
        int max = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == -1) {
                alreadyBursted++;
                continue;
            }
            //Try i ballon first
            int currentBallon = nums[i];
            nums[i] = -1;
            int left = 1;
            int right = 1;


            int leftIdx = i - 1;
            int rightIdx = i + 1;
            while (leftIdx >=0 && nums[leftIdx] == -1) {
                leftIdx--;
            }

            if(leftIdx >= 0) {
                left = nums[leftIdx];
            }

            while (rightIdx < nums.length && nums[rightIdx] == -1) {
                rightIdx++;
            }
            if(rightIdx < nums.length) {
                right = nums[rightIdx];
            }

            int curMax =  burstHelper(nums, preSum + left*currentBallon*right);
            if(curMax > max) {
                max = curMax;
            }

            //recover i ballon
            nums[i] = currentBallon;
        }

        if(alreadyBursted == nums.length) {
            return preSum;
        } else {
            //all ballon finished
            return max;
        }
    }

    //Devide and use memorization(for middle item, track burst i's L,R elements's coin gain)
    //https://leetcode.com/discuss/72216/share-some-analysis-and-explanations

    public int maxCoins2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int ballonIdx = 1;
        int[] noneEmptyBallons = new int[nums.length + 2];
        for(int num : nums) {
            if(num != 0) {
                noneEmptyBallons[ballonIdx++] = num;
            }
        }

        noneEmptyBallons[0] = 1;
        noneEmptyBallons[ballonIdx] = 1;

        int[][] trackMatrix = new int[ballonIdx][ballonIdx];

        return burstByRange(trackMatrix, 0, ballonIdx, noneEmptyBallons);

    }

    private int burstByRange(int[][] trackMatrix, int l, int r, int[] balloons) {
        if(r == l + 1) {
            //no balloon to burst
            return 0;
            //return 1;
        }
        if(trackMatrix[l][r] > 0) {
            return trackMatrix[l][r];
        }
        int maxCoinInRange = 0;
        for(int m = l + 1; m < r; m++) {
            /* this m is the last to burst, so left is l, right is r not m+1
            its sub problem should have m as boundry
            maxCoinInRange = Math.max(maxCoinInRange,
                    balloons[m-1]*balloons[m]*balloons[m+1]
                    + burstByRange(trackMatrix, l, m-1, balloons)
                            + burstByRange(trackMatrix, m+1, r, balloons));
           */
            maxCoinInRange = Math.max(maxCoinInRange,
                    balloons[l]*balloons[m]*balloons[r]
                            + burstByRange(trackMatrix, l, m, balloons)
                            + burstByRange(trackMatrix, m, r, balloons));
        }

        trackMatrix[l][r] = maxCoinInRange;
        return maxCoinInRange;
    }


    //DP bottom up
    public int maxCoins(int[] nums) {
        int[] nonEmptyBalloons = new int[nums.length + 2];
        int idx = 1;
        for(int num : nums) {
            if(num != 0) {
                nonEmptyBalloons[idx++] = num;
            }
        }
        nonEmptyBalloons[0] = nonEmptyBalloons[idx] = 1;
        int[][] dp = new int[idx+1][idx+1];
        int total = idx + 1;

        for(int diff = 2; diff < total; diff++) {
            for(int l = 0; l < total - diff; l++) {
                int right = l + diff;
                for(int i = l+1; i < right; i++) {
                    dp[l][right] = Math.max(dp[l][right],
                            nonEmptyBalloons[l]*nonEmptyBalloons[i]*nonEmptyBalloons[right]
                    + dp[l][i] + dp[i][right]);
                }
            }
        }

        return dp[0][total-1];
    }

}
