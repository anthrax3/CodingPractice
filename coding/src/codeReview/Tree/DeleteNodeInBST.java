package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 11/6/16.
 *
 * http://www.algolist.net/Data_structures/Binary_search_tree/Removal

public class DeleteNodeInBST {
  public TreeNode deleteNode(TreeNode root, int key) {
    if(root == null) {
      return null;
    }
    return deleteHelper(null, root, key);
  }

  private TreeNode deleteHelper(TreeNode parent, TreeNode cur, int key) {
    if(cur.val == key && cur.left == null && cur.right == null) {
      //left node, directly remove
      if(parent != null) {
        if(parent.left == cur) {
          parent.left = null;
        } else {
          parent.right = null;
        }
      }

      return parent;
    } else if(cur.val == key && (cur.left == null || cur.right == null)) {
      //one child
      TreeNode child = cur.left == null ? cur.right : cur.left;
      if(parent != null) {
        if(parent.left == cur) {
          parent.left = child;
        } else {
          parent.right = child;
        }
      }

      return parent;
    } else if(cur.val == key) {
      //have both child
      int min = findMin(cur.right);
      cur.val = min;
      cur.right = deleteHelper(cur, cur.right, key);
    }
  }

  private int findMin(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }

    return node.val;
  }
}
 */