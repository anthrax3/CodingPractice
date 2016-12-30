package codeReview.DataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * http://poj.org/summerschool/1_interval_tree.pdf
 *
 * For segment tree, update one node and update a range is different
 * updated a range can add new accumulated increase variable
 */
public class CountOfSmallerNumbersAfterSelf {
  public List<Integer> countSmaller(int[] nums) {
    SegmentTree range = new SegmentTree();
    //Should remove duplicated form nums and do discretization
    //离散化!!!
    Node root = range.build(-10000, 10000);
    List<Integer> res = new ArrayList<>();

    for(int i = nums.length - 1; i >= 0; i--) {
      //num can be null
      res.add(0, range.queryCountInRange(root, -1000, nums[i] - 1));
      range.addOne(root, nums[i]);
    }

    return res;
  }

  private static class Node{
    public Node left;
    public Node right;
    public int count;
    public int start;
    public int end;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
      this.count = 0;
      this.left = null;
      this.right = null;
    }
  }

  private class SegmentTree {

    public Node build(int start, int end) {
      //check validation
      if(start > end) {
        return null;
      }

      if(start == end) {
        return new Node(start, end);
      }
      Node root = new Node(start, end);
      int mid = start + (end - start)/2;

      root.left = build(start, mid);
      root.right = build(mid + 1, end);

      return root;
    }

    public void addOne(Node root, int index) {
      if(index < root.start || index > root.end) {
        //actually should throw a exception
        throw new RuntimeException(String.format("%d out of range", index));
        //return;
      }

      if(root.start == root.end && root.start == index) {
        root.count += 1;
        return;
      }

      int mid = root.start + (root.end - root.start)/2;
      if(index <= mid) {
        addOne(root.left, index);
      } else {
        addOne(root.right, index);
      }

      root.count = root.left.count + root.right.count;
    }

    public int queryCountInRange(Node root, int start, int end) {
      //no intersection
      if(root.start > end || root.end < start) {
        return 0;
      }

      //exact matched
      if(root.start == start && root.end == end) {
        return root.count;
      }

      int mid = root.start + (root.end - root.start)/2;


      int left = queryCountInRange(root.left, start, Math.min(mid, end));
      int right = queryCountInRange(root.right, Math.max(mid + 1, start), end);

      return left+right;
    }
  }
}
