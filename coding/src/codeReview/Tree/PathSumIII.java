package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/5/16.
 *
 *
 * traverse every not, start with each node to do a new traverse
 */
public class PathSumIII {
  public int pathSum(TreeNode root, int sum) {
    if(root == null) {
      return 0;
    }

    //for every point, the sum can include current node or not current node
    int ans = traverse(root, sum);
    ans += pathSum(root.left, sum);
    ans += pathSum(root.right, sum);

    return ans;
  }

  private int traverse(TreeNode root, int sum) {
    if(root == null) {
      return 0;
    }

    //path end with this node is a valid path
    int rest = (sum == root.val ? 1 : 0);
    //path trough this node also maybe a valid path
    rest += traverse(root.left, sum - root.val);
    rest += traverse(root.right, sum - root.val);

    return rest;
  }
}
