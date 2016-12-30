package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 11/2/16.
 */
public class BinaryTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    if(root == null) {
      return new ArrayList<>();
    }
    if(root.left == null && root.right == null) {
      List<String> res = new ArrayList<>();
      res.add(String.valueOf(root.val));
      return res;
    }

    List<String> left = binaryTreePaths(root.left);
    List<String> right = binaryTreePaths(root.right);

    ArrayList<String> result = new ArrayList<>();

    for (String next : left) {
      result.add(String.valueOf(root.val) + "->" + next);
    }

    for (String next : right) {
      result.add(String.valueOf(root.val) + "->" + next);
    }

    return result;
  }
}
