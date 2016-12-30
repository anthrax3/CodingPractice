package com.ms;

import codeReview.BinarySearch.TreeNode;
import codeReview.Utilities.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by wangdong on 11/27/16.
 */
public class InorderSuccessorInBST {
  public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
    if(root == null) {
      return null;
    }
    Stack<TreeNode> inOrder = new Stack<TreeNode>();

    TreeNode cur = root;
    while(cur != null) {
      inOrder.push(cur);
      cur = cur.left;
    }

    while(!inOrder.isEmpty()) {
      TreeNode top = inOrder.pop();
      if(top.right != null) {
        TreeNode curTop = top.right;
        while(curTop != null) {
          inOrder.push(curTop);
          curTop = curTop.left;
        }
      }
      //check stack not empty
      if(top == p && !inOrder.isEmpty()) {
        return inOrder.pop();
      }
    }

    return null;
  }

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root == null) {
      return null;
    }
    PriorityQueue<ListNode> a = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return 0;
      }
    });

    TreeNode successor = null;
    while (root != null) {
      if(root.val > p.val) {
        //search in left
        successor = root;
        root = root.left;
      } else if(root.val == p.val) {
        break;
      } else {
        //p > root, p in the right, the successor can't be current node
        root = root.right;
      }
    }

    if(root == null) {
      return null;
    }
    if(root.right == null) {
      //successor is previous root at up level
      return successor;
    } else {
      //find the left most node of this one
      TreeNode left = root.right;
      while (left.left != null) {
        left = left.left;
      }
      return left;
    }

  }
}
