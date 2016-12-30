package leetcode;

import codeReview.Utilities.NestedInteger;
import codeReview.string.MiniParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wangdong on 10/8/16.
 */
public class MiniParserTest {
  MiniParser parser;
  @Before
  public void setup() {
    parser = new MiniParser();
  }

  @Test
  public void test1() {
    NestedInteger res = parser.deserializeRecursive("[12,[9,10]]");
    Assert.assertFalse(res.isInteger());
  }
}
