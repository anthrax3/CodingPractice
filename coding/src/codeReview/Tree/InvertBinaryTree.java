package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/2/16.
 */
public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if(root == null) {
      return root;
    }

    dfs(root);
    return root;
  }

  private void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    dfs(root.right);

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
  }
}
