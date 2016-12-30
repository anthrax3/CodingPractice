package codeReview.Design;

import java.util.Stack;

/**
 * Created by wangdong on 8/13/16.
 */
public class BSTIterator {
  public class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
  }

  Stack<TreeNode> inOrder;

  public BSTIterator(TreeNode root) {
    inOrder = new Stack<>();
    TreeNode current = root;
    while (current != null) {
      inOrder.push(current);
      current = current.left;
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !inOrder.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    if(inOrder.isEmpty()) {
      return -1;
    }
    TreeNode smallest = inOrder.pop();

    TreeNode right = smallest.right;
    while (right != null) {
      inOrder.push(right);
      right = right.left;
    }

    return smallest.val;
  }


}
