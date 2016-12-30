package com.ms;

import codeReview.BinarySearch.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by wangdong on 11/19/16.
 */
public class SerializeAndDeserializeBinaryTree {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    ArrayList<String> res = new ArrayList<>();

    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if( cur != null) {
        res.add(String.valueOf(cur.val));
        queue.add(cur.left);
        queue.add(cur.right);
      } else {
        //if root is null ,return null
        res.add("null");
      }

    }
    return res.stream().collect(Collectors.joining(",")).toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] values = data.split(",");
    if(values.length == 0 || values[0].equals("null")) {
      return null;
    }

    TreeNode head = new TreeNode(Integer.valueOf(values[0]));
    TreeNode root = head;

    Queue<TreeNode> inorder = new LinkedList<>();
    inorder.add(root);

    int index = 1;
    while (index < values.length) {
      TreeNode cur = inorder.poll();
      if(!values[index].equals("null")) {
        cur.left = new TreeNode(Integer.valueOf(values[index]));
        inorder.add(cur.left);
      }
      index++;
      if(index < values.length) {
        if(!values[index].equals("null")) {
          cur.right = new TreeNode(Integer.valueOf(values[index]));
          inorder.add(cur.right);
        }
      }
      index++;
    }

    return head;
  }
}
