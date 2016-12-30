package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 10/31/16.
 */
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if(root == null) {
      return true;
    }
    return check(root.left, root.right);
  }

  private boolean check(TreeNode left, TreeNode right) {
    if(left == null && right == null) {
      return true;
    }

    if(left != null && right != null) {
      if(left.val != right.val) {
        return false;
      } else {
        return check(left.left, right.right) & check(left.right, right.left);
      }
    }
    return false;
  }
}
