package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by wangdong on 12/10/16.
 */
public class FindLeavesOfBinaryTree {
  private class ValueLevel {
    public int value;
    public int level;
    public ValueLevel(int value, int level) {
      this.value = value;
      this.level = level;
    }
  }

  public List<List<Integer>> findLeaves(TreeNode root) {
    if(root == null) {
      return new ArrayList<>();
    }

    List<ValueLevel> res = helper(root);

    HashMap<Integer, List<Integer>> levelValues = new HashMap<>();

    for(ValueLevel ele : res) {
      levelValues.putIfAbsent(ele.level, new ArrayList<>());
      levelValues.get(ele.level).add(ele.value);
    }

    return new ArrayList<>(levelValues.values());
  }

  private List<ValueLevel> helper(TreeNode root) {
    if(root.left == null && root.right == null) {
      ValueLevel leaf = new ValueLevel(root.val, 0);
    }

    List<ValueLevel> left = new ArrayList<>();
    List<ValueLevel> right = new ArrayList<>();
    if(root.left != null) {
      left = helper(root.left);
    }
    if(root.right != null) {
      right = helper(root.right);
    }

    int max = 0;
    for(ValueLevel ele : left) {
      max = Math.max(ele.level, max);
    }
    for(ValueLevel ele : right) {
      max = Math.max(ele.level, max);
    }

    List<ValueLevel> result = new ArrayList<>();
    result.addAll(left);
    result.addAll(right);
    result.add(new ValueLevel(root.val, max+1));

    return result;
  }
}
