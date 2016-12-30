package codeReview.BinarySearch;

/**
 * Created by wangdong on 12/7/16.
 */
public class DeleteNodeFromBST {
  public TreeNode deleteNode(TreeNode root, int key) {
    if(root == null) {
      return null;
    }

    //create a dummy node in case remove the root
    TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
    dummy.left = root;

    TreeNode parent = findNodeParent(dummy, root, key);

    if(parent.left != null && parent.left.val == key) {
      //delete left
      deleteNode(parent, parent.left);
    } else if(parent.right != null && parent.right.val == key) {
      //delete right
      deleteNode(parent, parent.right);
    } else {
      //not found
      return dummy.left;
    }

    return dummy.left;
  }

  //pass parent, current node
  private TreeNode findNodeParent(TreeNode parent, TreeNode root, int key) {
    if(root == null || root.val == key) {
      return parent;
    } else if(root.val > key) {
      return findNodeParent(root, root.left, key);
    } else {
      return findNodeParent(root, root.right, key);
    }
  }

  private void deleteNode(TreeNode parent, TreeNode target) {
    if(target.right == null) {
      //single link node, attach left to parent
      if(parent.left == target) {
        parent.left = target.left;
      } else {
        parent.right = target.left;
      }
    } else {
      //attach the right node's left most child to parent, remove left most node
      //TODO set father as target, find left most from target.right node
      TreeNode father = target;
      TreeNode leftTemp = target.right;

      while(leftTemp.left != null) {
        //move left
        father = leftTemp;
        leftTemp = leftTemp.left;
      }

      //remove the left most Node from father
      if(father.left == leftTemp) {
        father.left = leftTemp.right;
      } else {
        //in case delete node has has a right node without left most node
        father.right = leftTemp.right;
      }
            /*
            if(leftTemp.right == null) {
                father.left = null;
            } else {
                father.left = leftTemp.right;
            }*/

      //attach delete node's child to left most node
      leftTemp.left = target.left;
      leftTemp.right = target.right;
      //attach left most to parent delte node
      if(parent.left == target) {
        parent.left = leftTemp;
      } else {
        parent.right = leftTemp;
      }
    }
  }
}
