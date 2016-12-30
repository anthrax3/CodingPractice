package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 10/31/16.
 */
public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    res.add(root.val);
    res.addAll(inorderTraversal(root.left));
    res.addAll(inorderTraversal(root.right));

    return res;
  }
}
