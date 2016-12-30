package codeReview.Math;

/**
 * Created by wangdong on 10/18/16.
 */
public class NumberOf1Bits {
  public int hammingWeight(int n) {
    int result = 0;
    for(int i = 0; i < 32; i++) {
      result += (n>>i)&1;
    }

    return result;
  }
}
