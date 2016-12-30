package codeReview.BinarySearch;

import java.util.ArrayList;

/**
 * Created by wangdong on 6/12/16.
 */
public class KthSmallestElementInBST {
  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> sortedValue = new ArrayList<>();
    inOrderTraverse(root, sortedValue);
    return sortedValue.get(k-1);
  }

  public void inOrderTraverse(TreeNode root, ArrayList<Integer> sortedNumbers) {

    if(root == null) {
      return;
    }
    inOrderTraverse(root.left, sortedNumbers);
    sortedNumbers.add(root.val);
    inOrderTraverse(root.right, sortedNumbers);
  }
}
