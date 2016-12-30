package codeReview.BinarySearch;

/**
 * Created by wangdong on 6/12/16.
 */
public class CountCompleteTreeNodes {

  public int countNodesExceed(TreeNode root) {
    if(root == null) {
      return 0;
    }
    if(root.left == null && root.right == null) {
      return 1;
    }

    return 1 + countNodesExceed(root.left) + countNodesExceed(root.right);
  }

  public int countNodes(TreeNode root) {
    if(root == null) {
      return 0;
    }
    if(root.left == null && root.right == null) {
      return 1;
    }

    int leftHeight = 0;
    TreeNode left = root.left;
    while (left != null) {
      leftHeight++;
      left = left.left;
    }

    int rightHeight = 0;
    TreeNode right = root.right;
    while (right != null) {
      rightHeight++;
      right = right.right;
    }

    if(leftHeight == rightHeight) {
      //full tree, 2^H - 1 nodes
      return (int)Math.pow(2, leftHeight) - 1;
    } else  {
      return 1 + countNodes(root.left) + countNodes(root.right);
    }

  }
}
