package leetcode;

import codeReview.Sort.MaximumGap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wangdong on 10/12/16.
 */
public class MaxGapTest {
  MaximumGap maxGap;
  @Before
  public void setup() {
    maxGap  = new MaximumGap();
  }

  @Test
  public void test1() {
    int[] in = new int[] {100, 3, 2, 1};
    int res = maxGap.maximumGap(in);
    Assert.assertFalse(res == 1);
  }
}
