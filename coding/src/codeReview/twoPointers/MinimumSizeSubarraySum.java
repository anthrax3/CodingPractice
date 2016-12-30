package codeReview.twoPointers;

/**
 * Created by wangdong on 6/8/16.
 */
public class MinimumSizeSubarraySum {
  public int minSubArrayLen(int s, int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int start = 0;
    int end = 0;
    int currentSum = 0;
    int minLen = Integer.MAX_VALUE;

    while (end < nums.length) {
      //move end point until reach the sum
      while (end < nums.length && currentSum < s) {
        currentSum += nums[end++];
      }

      //move start when we already have enough sum, check each length, may be the end is large enough
      //to replace several start elements
      while (start <= end && currentSum >= s) {
        if(currentSum >= s) {
          minLen = Math.min(minLen, end - start + 1);
        }
        currentSum -= nums[start++];
      }
    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }
}
