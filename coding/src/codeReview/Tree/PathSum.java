package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 10/31/16.
 */
public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if(root == null) {
      return false;
    }

    return helper(0, root, sum);
  }


  private boolean helper(int current, TreeNode root, int sum) {
    if(root == null) {
      return false;
    }
    if(root.left == null && root.right == null) {
      //left
      if(current + root.val == sum) {
        return true;
      } else {
        return false;
      }
    }

    //not leaf
    return helper(current+root.val, root.left, sum) | helper(current+root.val, root.right, sum);
  }


}
