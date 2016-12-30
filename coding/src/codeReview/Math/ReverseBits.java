package codeReview.Math;

/**
 * Created by wangdong on 10/18/16.
 *
 * 100011
 * ->
 * 110001
 */
public class ReverseBits {
  public int reverseBits(int n) {
    int result = 0;
    for(int i = 0; i < 32; i++) {
      //get last bit to first bit
      result |= (n>>i & 1) << (31 - i);
    }

    return result;
  }
}
