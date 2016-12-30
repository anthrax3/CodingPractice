package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/2/16.
 */
public class LCABinarySearchTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }

    if(p.val > q.val) {
      //change the overder
      return lowestCommonAncestor(root, q, p);
    }

    if(root == p || root == q) {
      return root;
    }

    if (p.val < root.val && q.val > root.val) {
      return root;
    } else if(p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }
}
