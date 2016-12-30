package com.ms;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/13/16.
 * http://www.jiuzhang.com/solutions/binary-tree-maximum-path-sum/
 *
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting
 node to any node in the tree along the parent-child connections. The path must
 contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {
  private class Info {
    //the max of full path or the max value get from child node
    public int globalMax;

    //current max is a single path, go left, got right or exclude this node
    public int maxOfCurrent;

    public Info(int max, int global) {
      this.maxOfCurrent = max;
      this.globalMax = global;
    }
  }
  public int maxPathSum(TreeNode root) {
    if(root == null) {
      return 0;
    }

    Info head = helper(root);
    return head.globalMax;
  }

  private Info helper(TreeNode root) {
    if(root == null) {
      return new Info(0, Integer.MIN_VALUE);
    }

    Info left = helper(root.left);
    Info right = helper(root.right);

    //can through this node, go left or right
    int currentMax = root.val + Math.max(left.maxOfCurrent, right.maxOfCurrent);
    //can avoid this node, don't got this way
    currentMax = Math.max(0, currentMax);

    int global = Math.max(root.val + left.maxOfCurrent + right.maxOfCurrent, Math.max(left.globalMax, right.globalMax));
    return new Info(currentMax, global);
  }
}
