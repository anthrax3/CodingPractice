package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangdong on 11/6/16.
 */
public class SerializeAndDeserializeBST {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null) {
      return "";
    }
    Queue<TreeNode> level = new LinkedList<>();
    StringBuilder ans = new StringBuilder();
    level.add(root);
    while (!level.isEmpty()) {
      TreeNode cur = level.poll();
      if(cur != null) {
        ans.append(cur.val);
        ans.append(",");
        level.add(cur.left);
        level.add(cur.right);
      } else {
        ans.append("#");
        ans.append(",");
      }
    }

    //remove last "."
    String res = ans.toString();

    return res.substring(0, res.length()-1);
  }

  /*
     0
   1   2
  3 4 5 6

  from odd and even, we know left right
  */

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data == null || data.isEmpty()) {
      return null;
    }

    //12 => [1][2]
    //char[] values = data.toCharArray();
    String[] values = data.split(",");
    TreeNode head = new TreeNode(Integer.valueOf(values[0]));
    Queue<TreeNode> tree = new LinkedList<>();
    tree.add(head);
    int i = 1;

    while (!tree.isEmpty()) {
      TreeNode node = tree.poll();
      if(node == null) {
        // null node do not have lef/right in the array
        continue;
      }

      if(!values[i].equals("#")) {
        node.left = new TreeNode(Integer.valueOf(values[i]));
      } else {
        node.left = null;
      }
      tree.add(node.left);
      i++;

      if(!values[i].equals("#")) {
        node.right = new TreeNode(Integer.valueOf(values[i]));
      } else {
        node.right = null;
      }
      tree.add(node.right);
      i++;
    }

    return head;
  }
}
