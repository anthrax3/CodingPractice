package codeReview.Array;

/**
 * Created by wangdong on 7/26/16.
 *
 * Given an array of n integers where n > 1, nums,
 * return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity?
 (Note: The output array does not count as extra space
 for the purpose of space complexity analysis.)
 */

public class ProductofArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    if(nums == null || nums.length == 0) {
      return new int[0];
    }
    int[] leftToRightProduct = new int[nums.length];
    int[] rightToLeftProduct = new int[nums.length];
    int[] res = new int[nums.length];
    for(int i = 0; i < nums.length; i++) {
      res[i] = 1;
    }
    // i-2, i-1, [i], i+1, i+2..
    //[.. i-2, i-1] * [i+1, i+2, ... i+n]
    int temp = 1;
    for(int i = 0; i < nums.length; i++) {
      temp *= nums[i];
      leftToRightProduct[i] = temp;
      if(i-1 >= 0) {
        res[i] *= leftToRightProduct[i - 1];
      }
    }
    temp = 1;
    for(int i = nums.length - 1; i >= 0; i--) {
      temp *= nums[i];
      rightToLeftProduct[i] = temp;
      if(i+1 <= nums.length-1) {
        res[i] *= rightToLeftProduct[i + 1];
      }
    }

    return res;
  }
}
