package com.ms;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/13/16.
 */
public class ClosestBinarySearchTreeValue {
  public int closestValue(TreeNode root, double target) {
    if(root == null) {
      return 0;
    }

    TreeNode next = target < root.val ? root.left : root.right;
    if(next == null) {
      return root.val;
    }
    int closestOnNext = closestValue(next, target);
    //compare next and current
    return Math.abs(root.val - target) < Math.abs(closestOnNext - target) ? root.val : closestOnNext;
  }
}
