package codeReview.Array;

/**
 * Created by wangdong on 7/27/16.
 */
public class MissingNumber {

  // x^(x^y) = y
  public int missingNumber(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }
    int miss = 0;
    //xor 1 to n
    for(int i = 0; i < nums.length; i++) {
      miss ^= (i+1);
      miss ^= nums[i];
    }

    return miss;
  }
}
