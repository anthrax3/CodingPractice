package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 10/31/16.
 *
 * in order, check the value breack rule, then mark two node, then switch value
 */
public class RecoverBinarySearchTree {


  public void recoverTree(TreeNode root) {
    if(root == null) {
      return;
    }
    TreeNode first = null;
    TreeNode second = null;

    inorder(root, null, first, second);
    int secondVal = second.val;
    second.val = first.val;
    first.val = secondVal;
    return;
  }

  private void inorder(TreeNode treeNode,TreeNode pre, TreeNode first, TreeNode second) {
    if(treeNode == null) {
      return;
    }

    inorder(treeNode.left, pre, first, second);
    //check current
    if(pre != null && pre.val > treeNode.val) {
      if (first == null){
        ///!!----first
        // 5, 9, 15, 24 , 38
        // 5, 24, 15, 9, 38
        first = pre;
        second = treeNode;
      } else {
        second = treeNode;
      }
    }

    pre = treeNode;
    inorder(treeNode.right, pre, first, second);

    return;
  }
}
