package codeReview.Math;

/**
 * Created by wangdong on 10/18/16.
 */
public class ReverseInteger {
  public int reverse(int x) {
    long result = 0;

    while (x != 0) {
      result = result*10 + x%10;
      x /= 10;
    }

    return (result > (long)Integer.MAX_VALUE || result < (long)Integer.MIN_VALUE) ? 0 : (int)result;
  }
}
