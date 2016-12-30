package codeReview.Array;

/**
 * Created by wangdong on 11/11/16.
 */
public class JumpGame2 {
  public int jump(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int start = 0;
    int end = 0;
    int steps = 0;

    while (end < nums.length-1) {
      //update steps first, as it may returned in the for loop
      steps++;

      int nextEnd = 0;
      //search the range current can arrive
      for(int i = start; i <= end; i++) {
        //update new range
        nextEnd = Math.max(i+nums[i], nextEnd);
        if(end >= nums.length-1) {
          return steps;
        }
      }

      start = end+1;
      end = nextEnd;

      if(start > end) {
        //can't achieve
        return Integer.MAX_VALUE;
      }
    }

    //for [1] will reach here
    return steps;
  }
}
