package codeReview.Array;

/**
 * Created by wangdong on 11/12/16.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int sum = 0;
    int max = Integer.MIN_VALUE;

    //sliding window do update
    for(int i = 0; i < nums.length; i++) {
      if(sum < 0) {
        //previous elements no contribute, discard
        sum = 0;
      }
      //have current element in the sum
      sum += nums[i];
      max = Math.max(max, sum);
    }

    return max;
  }
}
