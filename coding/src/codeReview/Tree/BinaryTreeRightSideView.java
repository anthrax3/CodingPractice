package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 10/16/16.
 *
 * Intger can't do reference
 */
public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    if(root == null) {
      return new ArrayList<>();
    }

    List<Integer> res = new ArrayList<>();

    dfs(root, res, 0, 0);
    return res;
  }

  private int dfs(TreeNode root, List<Integer> res, int currentLevel, int nextViewLevel) {
    if(root == null) {
      return nextViewLevel;
    }
    if(nextViewLevel == currentLevel) {
      res.add(root.val);
      nextViewLevel++;
    }
    nextViewLevel = dfs(root.right, res, currentLevel+1, nextViewLevel);
    nextViewLevel = dfs(root.left, res, currentLevel+1, nextViewLevel);

    return nextViewLevel;
  }
}
