package leetcode;

import codeReview.BinarySearch.TreeNode;
import codeReview.Tree.SerializeAndDeserializeBST;
import org.junit.Test;

/**
 * Created by wangdong on 11/6/16.
 */
public class SerializeTest {
  @Test
  public void test() {
    SerializeAndDeserializeBST s = new SerializeAndDeserializeBST();
    TreeNode a = s.deserialize("1");
  }
}
