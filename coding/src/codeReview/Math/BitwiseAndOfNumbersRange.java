package codeReview.Math;

/**
 * Created by wangdong on 10/18/16.
 */
public class BitwiseAndOfNumbersRange {

  public int rangeBitwiseAnd(int m, int n) {
    int offset = 0;
    while (m != n) {
      m = m>>1;
      n = n>>1;
      offset++;
    }

    return m<<offset;
  }
}
