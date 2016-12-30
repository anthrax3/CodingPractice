package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wangdong on 10/31/16.
 */
public class BinaryTreeZigzagLevelTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    Queue<TreeNode> level = new LinkedList<>();

    if(root == null) {
      return new ArrayList<>();
    }

    List<List<Integer>> res = new ArrayList<>();
    level.add(root);
    int levels = 0;
    while (!level.isEmpty()) {
      ArrayList<TreeNode> temp = new ArrayList<>();
      ArrayList<Integer> oneLevel = new ArrayList<>();
      while (!level.isEmpty()) {
        TreeNode head = level.poll();
        if(levels%2 == 0) {
          oneLevel.add(head.val);
        } else {
          oneLevel.add(0, head.val);
        }

        if(head.left != null) {
          temp.add(head.left);
        }
        if(head.right != null) {
          temp.add(head.right);
        }
      }

      level.addAll(temp);
      levels++;
    }

    return res;
  }
}
