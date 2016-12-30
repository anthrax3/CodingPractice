package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/2/16.
 */
public class LCA {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q) {
      return root;
    }

    TreeNode leftFind = lowestCommonAncestor(root.left, p, q);
    TreeNode rightFind = lowestCommonAncestor(root.right, p, q);
    if(leftFind != null && rightFind != null) {
      return root;
    }

    return leftFind == null ? rightFind : leftFind;

  }
}
