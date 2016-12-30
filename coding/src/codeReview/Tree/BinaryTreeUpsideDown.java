package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 12/9/16.
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty, flip it upside down and turn
 * it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
     1
    / \
  2   3
 / \
 4 5
 return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
  5 2
 / \
 3 1

 */
public class BinaryTreeUpsideDown {
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if(root == null) {
      return root;
    }

    //initial root's parent and left node as null
    TreeNode parent = null;
    TreeNode right = null;
    TreeNode node = root;

    while(node != null) {
      //save left
      TreeNode nextleft = node.left;
      //attache node left to previous right
      node.left = right;

      TreeNode nextRight = node.right;
      node.right = parent;


      parent = node;
      right = nextRight;
      node = nextleft;
    }

    return parent;
  }
}
