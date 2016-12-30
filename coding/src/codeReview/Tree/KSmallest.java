package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.Stack;

/**
 * Created by wangdong on 11/2/16.
 */
public class KSmallest {
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> inOrder = new Stack<>();

    TreeNode left = root;
    while (left != null) {
      inOrder.push(left);
      left = left.left;
    }

    int quantity = 0;
    while (!inOrder.isEmpty()) {
      TreeNode cur = inOrder.pop();
      quantity++;
      if(quantity == k) {
        return cur.val;
      }
      TreeNode curRight = cur.right;
      while (curRight != null) {
        inOrder.push(curRight);
        curRight = curRight.left;
      }
    }

    return -1;
  }

}
