package codeReview.dynamicPrograming;

import java.util.Arrays;

/**
 * Created by wangdong on 6/22/16.
 */
public class LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }
    //dp[i] means longest increasing sequence include num[i]
    // the num[i] is the max number in this sequence
    int[] dp = new int[nums.length];
    dp[0] = 1;

    for(int i = 1; i < nums.length; i++) {
      //itself as a sequece has number 1
      dp[i] = 1;
      for(int j = 0; j < i; j++) {
        // 1 3 6 2 9 4
        //         |
        // 1 2 3 2
        // 2 3 4 3 4
        //           |
        // 2 3 X 3 X 3

        if(nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }
}
