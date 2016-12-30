package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/2/16.
 */
public class CountCompleteTreeNodes {
  public int countNodesSimple(TreeNode root) {
    if(root == null) {
      return 0;
    }

    return 1 + countNodesSimple(root.left) + countNodesSimple(root.right);
  }

  public int countNodes(TreeNode root) {
    if(root == null) {
      return 0;
    }

    int leftDepth = 1;
    int rightDepth = 1;
    TreeNode left = root.left;
    TreeNode right = root.right;

    while (left != null) {
      left = left.left;
      leftDepth++;
    }

    while (right != null) {
      right = right.right;
      rightDepth++;
    }

    if(rightDepth == leftDepth) {
      //height is 2^h - 1
      // 2^h is 1<<h not 2^h
      return (1<<leftDepth) - 1;
    } else {
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }
}
