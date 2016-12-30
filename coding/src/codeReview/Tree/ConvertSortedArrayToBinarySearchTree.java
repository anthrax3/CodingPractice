package codeReview.Tree;

import codeReview.BinarySearch.TreeNode;

/**
 * Created by wangdong on 10/31/16.
 */
public class ConvertSortedArrayToBinarySearchTree {
  public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0) {
      return null;
    }

    return helper(nums, 0, nums.length-1);
  }

  private TreeNode helper(int[] nums, int start, int end) {
    if(start > end) {
      return null;
    }
    if(start == end) {
      return new TreeNode(nums[start]);
    }
    int middle = start + (end-start)/2;
    TreeNode root = new TreeNode(nums[middle]);
    root.left = helper(nums, start, middle-1);
    root.right = helper(nums, middle+1, end);

    return root;
  }
}
