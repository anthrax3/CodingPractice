package leetcode;

import codeReview.BinarySearch.TreeNode;
import codeReview.Tree.CountCompleteTreeNodes;
import org.junit.Test;

/**
 * Created by wangdong on 11/2/16.
 */
public class TreeTest {
  @Test
  public void testCount() {
    CountCompleteTreeNodes count = new CountCompleteTreeNodes();
    int a =  count.countNodes(new TreeNode(1));
    System.out.println(a);
  }

}
