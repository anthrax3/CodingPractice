package codeReview.dynamicPrograming;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 10/15/16.
 */
public class HouseBobberTree {
  public int solve(TreeNode root, boolean robRootPossible) {
    if(root == null) {
      return 0;
    }

    if(robRootPossible == true) {
      //can rob or not rob
      return Math.max(
              solve(root.left, false) + solve(root.right, false) + root.val,
              solve(root.left, true) + solve(root.right, true)
      );
    } else {
      return solve(root.left, true) + solve(root.right, true);
    }
  }


  public int rob(TreeNode root) {
    if(root == null) {
      return 0;
    }

    return solve(root, true);
  }
}
