package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangdong on 11/6/16.
 */
public class SumOfLeftLeaves {
  public int sumOfLeftLeaves1(TreeNode root) {
    if(root == null) {
      return 0;
    }

    if(root.left != null && root.left.left == null && root.left.right == null) {
      //next left node is left leaf node
      return root.left.val + sumOfLeftLeaves1(root.right);
    } else {
      return sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }
  }

  public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) {
      return 0;
    }

    Queue<TreeNode> level = new LinkedList<>();
    level.add(root);
    int ans = 0;

    while (!level.isEmpty()) {
      TreeNode head = level.poll();
      if(head.left != null && head.left.left == null && head.left.right == null) {
        //this node's left node is a left leaf node
        ans += head.left.val;
      }
      if(head.left != null) {
        level.add(head.left);
      }
      if(head.right != null) {
        level.add(head.right);
      }
    }

    return ans;
  }
}
