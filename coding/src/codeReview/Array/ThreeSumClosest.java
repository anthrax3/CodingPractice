package codeReview.Array;

import java.util.Arrays;

/**
 * Created by wangdong on 11/7/16.
 *
 *   For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int closest = Integer.MAX_VALUE;

    //should not use (closest - target) as if target is negative this number will overflow
    int diff = Integer.MAX_VALUE;
    //first sort the array
    Arrays.sort(nums);

    for(int first = 0; first < nums.length - 2; first++) {

      int second = first+1;
      int third = nums.length - 1;

      while (second < third) {
        int sum = nums[first] + nums[second] + nums[third];
        if(sum < target) {
          second++;
        } else if (sum == target) {
          return target;
        } else {
          third--;
        }

        if(Math.abs(sum - target) < diff) {
          closest = sum;
          diff = Math.abs(sum - target);
        }
      }
    }

    return closest;
  }
}
