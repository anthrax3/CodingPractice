package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 10/31/16.
 */
public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) {
      return true;
    }

    if(p != null && q != null) {
      if (p.val != q.val) {
        return false;
      } else {
        return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
      }
    }

    return false;

  }
}
