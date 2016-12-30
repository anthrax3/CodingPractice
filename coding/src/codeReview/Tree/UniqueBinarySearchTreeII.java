package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 10/31/16.
 */
public class UniqueBinarySearchTreeII {
  private List<TreeNode> helper(int start, int end) {
    List<TreeNode> roots = new ArrayList<>();

    if(start > end) {
      //leaf
      roots.add(null);
      return roots;
    }
    for(int i = start; i <= end; i++) {

      List<TreeNode> leftRoots = helper(start, i - 1);
      List<TreeNode> rightRoots = helper(i + 1, end);
      for (TreeNode left : leftRoots) {
        for (TreeNode right : rightRoots) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          roots.add(root);
        }
      }
    }

    return roots;
  }

  public List<TreeNode> generateTrees(int n) {
    if(n >= 1) {
      return helper(1, n);
    } else {
      return new ArrayList<>();
    }
  }
}
