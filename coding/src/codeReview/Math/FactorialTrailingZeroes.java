package codeReview.Math;

/**
 * Created by wangdong on 10/17/16.
 */
public class FactorialTrailingZeroes {
  public int trailingZeroes(int n) {

    int result = 0;

    while (n > 0) {
      //30/ 5 = 6
      //1*5, 2*5, 3*5, 4*5, 5*5, 6*5 exist in the 6!
      result += n/5;
      n = n/5;
    }

    return result;
  }

}
