package leetcode;

import codeReview.Math.FractionToRecurringDecimal;
import org.junit.Test;

/**
 * Created by wangdong on 10/16/16.
 */
public class FractionToStringTest {
  @Test
  public void test1() {
    FractionToRecurringDecimal fs = new FractionToRecurringDecimal();
    fs.fractionToDecimal(-2147483648 , -1999);
  }
}
