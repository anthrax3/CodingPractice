package codeReview.Tree;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
  public static List<Integer> countSmaller(int[] nums) {
    if(nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    BST bst = new BST();
    //reverse
    for(int i = nums.length - 1; i >= 0; i--) {
      //reverse
      result.add(0, bst.insert(nums[i]));
    }

    return result;
  }

  private static class Node {
    public int value;
    public int equalCount;
    public int smallerCount;
    public Node left;
    public Node right;

    public Node(int value) {
      this.value = value;
      this.equalCount = 1;
      left = null;
      right = null;
    }
  }

  private static class BST {
    private Node root;

    public int insert(int value) {
      if(root == null) {
        root = new Node(value);
        return 0;
      }

      Node head = root;
      int smallThanThisCount = 0;

      //As reserved do the insert,
      // current exist are all nodes need to be checked for this one (left nodes of this one)
      while (head != null) {
        if(value < head.value) {
          head.smallerCount += 1;

          if(head.left == null) {
            head.left = new Node(value);
            break;
          }
          head = head.left;
        } else if (value > head.value){
          smallThanThisCount += head.smallerCount + head.equalCount;
          if(head.right == null) {
            head.right = new Node(value);
            break;
          }
          head = head.right;
        } else {
          smallThanThisCount += head.smallerCount;
          head.equalCount += 1;
          break;
        }
      }

      return smallThanThisCount;
    }
  }
}
