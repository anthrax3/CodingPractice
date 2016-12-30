package codeReview.Array;

import java.util.Arrays;

/**
 * Created by wangdong on 11/13/16.
 */
public class PlusOne {
  public int[] plusOne(int[] digits) {
    if(digits == null || digits.length == 0) {
      return digits;
    }

    int high = 1;
    for(int i = digits.length-1; i >= 0; i--) {
      int cur = digits[i];
      digits[i] = (cur + high)%10;
      high = (cur + high)/10;
    }

    if(high > 0) {
      int[] res = new int[digits.length+1];
      res[0] = high;
      for(int i = 0; i < digits.length; i++) {
        res[i+1] = digits[i];
      }

      return res;
    } else {
      return digits;
    }
  }
}
