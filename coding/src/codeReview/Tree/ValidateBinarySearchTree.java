package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 10/31/16.
 *
 * left sub tree's max val < root.val
 * right sub tree's min val > root.val
 */
public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    return checkRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean checkRange(TreeNode root, long min, long max) {
    if(root == null) {
      return true;
    }

    if(root.val <= min || root.val >= max) {
      return false;
    } else {
      return checkRange(root.left, min, root.val) & checkRange(root.right, root.val, max);
    }
  }
}
