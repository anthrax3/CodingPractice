package codeReview.Array;

/**
 * Created by wangdong on 7/28/16.
 */
public class MoveZeros {

  public void moveZeroes1(int[] nums) {
    if(nums == null || nums.length <= 1) {
      return;
    }
    int start = 0;
    int end = 0;

    while (true) {
      //find first 0
      while (start < nums.length && nums[start] != 0) {
        start++;
      }
      //can't find 0
      if(start >= nums.length) {
        return;
      }
      //find first non -zero
      while (end < nums.length && nums[end] == 0 ) {
        end++;
      }

      //can't find non-zero
      if(end >= nums.length) {
        return;
      }

      //swap
      if(start < end) {
        nums[start] = nums[end];
        nums[end] = 0;
      } else {
        end = start + 1;
      }
    }

  }

  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return;
    }
    int firstZeroIdx = 0;

    for(int firstNoneZeroIdx = 0; firstNoneZeroIdx < nums.length; firstNoneZeroIdx++) {
      if(nums[firstNoneZeroIdx] != 0) {
        nums[firstZeroIdx] = nums[firstNoneZeroIdx];
        nums[firstNoneZeroIdx] = 0;
        firstZeroIdx += 1;
      }
    }
  }
}
