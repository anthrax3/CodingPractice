package codeReview.dynamicPrograming;

import java.util.Arrays;

/**
 * Created by wangdong on 10/15/16.
 *
 * i is the length
 * dp[i] = Max (dp[i-2] + num[i], dp[i-1])
 */
public class HouseRobber {
  public int rob(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int[] maxValueAtLenght = new int[nums.length + 1];
    maxValueAtLenght[0] = 0;
    maxValueAtLenght[1] = nums[0];

    for(int length = 2; length <= nums.length; length++) {
      int houseIdx = length-1;
      maxValueAtLenght[length] = Math.max(maxValueAtLenght[length-1], maxValueAtLenght[length-2] + nums[houseIdx]);
    }

    return maxValueAtLenght[nums.length];
  }

  public int rob2(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }
    if(nums.length == 1) {
      return nums[0];
    }

    //if length >= 2
    int[] includeHead = Arrays.copyOfRange(nums, 0 , nums.length - 1);
    int[] excludeHead = Arrays.copyOfRange(nums, 1 , nums.length);

    return  Math.max(rob(includeHead), rob(excludeHead));
  }
}
