package codeReview.greedy;

import java.util.Set;

/**
 * Created by wangdong on 5/16/16.
 */
public class MinArrayPatch {
    public static int minPatches(int[] nums, int n) {
        int sum = 0;
        int idx = 0;
        int ans = 0;



        while(sum < n) {
            //Check existing nums one by one until find one can't be represent by current integer
            while (idx < nums.length && nums[idx] <= sum) {
                System.out.println(nums[idx]);
                if(sum != nums[idx]) {
                    sum += nums[idx];
                }

                idx++;
            }

            //add missing value until meet idx
            while (sum < nums[idx]) {
                int nextNum = sum + 1;
                System.out.println(nextNum);
                sum += nextNum;
                if(sum != nums[idx]) {
                    ans++;
                }
            }

            if(idx == nums.length) {
                int nextNum = sum + 1;
                System.out.println(nextNum);
                sum += nextNum;
                ans++;
            }
        }

        return ans;
    }
}
