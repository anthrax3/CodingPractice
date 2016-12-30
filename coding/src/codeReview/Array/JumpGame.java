package codeReview.Array;

/**
 * Created by wangdong on 11/12/16.
 */
public class JumpGame {
  public boolean canJumpSlow(int[] nums) {
    if(nums == null || nums.length == 0) {
      return false;
    }

    for(int i = 1; i < nums.length; i++) {
      boolean canReachCurrent = false;
      for(int j = 0; j < i; j++) {
        //check all nodes before this, to see whether it is possible to arrive current node
        if(nums[j] + j >= i) {
          canReachCurrent = true;
          break;
        }
      }

      if(canReachCurrent == false) {
        return false;
      }
    }

    return true;
  }

  public boolean canJumpFast(int[] nums) {
    if(nums == null || nums.length == 0) {
      return false;
    }

    int start = 0;
    int end = 0;

    while (end < nums.length-1) {
      int nextEnd = 0;
      for(int i = start; i <= end; i++) {
        nextEnd = Math.max(nextEnd, nums[i] + i);
        if(nextEnd >= nums.length-1) {
          return true;
        }
      }

      start = end + 1;
      end = nextEnd;
      if(start > end) {
        return false;
      }
    }

    return true;
  }
}
