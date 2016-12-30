package com.ms;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/13/16.
 */
public class LargestBstSubtree {
  //Bottom up approach

  private class Info {
    public int largestNum;
    public int small;
    public int large;
    public boolean isBst;

    public Info(int largestNum, int small, int large, boolean isBst) {
      this.largestNum = largestNum;
      this.small = small;
      this.large = large;
      this.isBst = isBst;
    }
    public Info() {
    }
  }
  public int largestBSTSubtree(TreeNode root) {
    if(root == null) {
      return 0;
    }
    Info res = helper(root);
    return res.largestNum;
  }

  public Info helper(TreeNode root) {
    if(root == null) {
      //return a BST ture but small / large are reversed as a flag
      Info leaf = new Info(0, Integer.MAX_VALUE, -Integer.MAX_VALUE, true);
      return leaf;
    }

    Info left = helper(root.left);
    Info right = helper(root.right);

    Info rest = new Info();
    if(left.small < root.val) {
      rest.small = left.small;
    } else {
      rest.small = root.val;
    }

    rest.large = Math.max(right.large, root.val);

    //if left or right are leaf, can also go into this branch
    if(left.isBst && right.isBst && left.large < root.val && right.small > root.val) {
      int totalNum = left.largestNum + right.largestNum + 1;
      rest.largestNum = totalNum;
      rest.isBst = true;
    } else {
      rest.largestNum = Math.max(left.largestNum, right.largestNum);
      rest.isBst = false;
    }

    return rest;
  }
}
