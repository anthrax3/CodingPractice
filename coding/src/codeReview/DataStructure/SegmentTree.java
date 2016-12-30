package codeReview.DataStructure;

import java.util.List;
import java.util.Map;

/**
 * Created by wangdong on 5/30/16.
 */
public class SegmentTree {
  public class Node {
    //This is the basic implementation, the node content may differ based on user case
    int count;
    int start;
    int end;
    boolean lazyFlag;
    Node left;
    Node right;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
      this.count = 0;
      this.lazyFlag = false;
      left = null;
      right = null;
    }
  }

  //build a new tree, data is mapping function, from index stat - end to value
  //y = Fun(x)
  //离散化的时候如果排完序后相邻的元素值不相邻的话，是不能离散为相邻的两个元素的
  public Node build(int[] data, int start, int end) {
    if(start > end) {
      return null;
    }

    if(start == end) {
      return new Node(data[start], data[end]);
    }
    int mid = start + (end - start)/2;
    Node root = new Node(data[start], data[end]);
    root.left = build(data, start, mid);
    root.right = build(data, mid + 1, end);
    return root;
  }

  //can't pass in map func and use it create tree as we add some nodes in the discription
  public Node build(int start, int end) {
    if(start > end) {
      return null;
    }

    if(start == end) {
      return new Node(start, end);
    }
    int mid = start + (end - start)/2;
    Node root = new Node(start, end);
    root.left = build(start, mid);
    root.right = build(mid + 1, end);
    return root;
  }

  public void add(Node root, int key) {
    if (root != null && root.start <= key && root.end >= key) {
      root.count++;
      add(root.left, key);
      add(root.right, key);
    }
  }

  public void add(Node root, int key, int value) {
    if(root != null && root.start <=key && root.end >= key) {
      root.count += value;
      add(root.left, key, value);
      add(root.right, key, value);
    }
  }


  public void updateLeaf(Node root, int left, int right, int value) {
    if(root == null || right < root.start || left > root.end) {
      return;
    }

    if(root.start == left && root.end == right) {
      root.lazyFlag = true;
      root.count = Math.max(value, root.count);
      return;
    }

    int mid = root.start + (root.end - root.start)/2;
    updateLeaf(root.left, Math.max(left, root.start), Math.min(right, mid), value);
    updateLeaf(root.right, Math.max(mid + 1, left), Math.min(right, root.end), value);
  }

  public void getSkyLineResult(Map<Integer, Integer> func, Node root, List<int[]> res) {


    if(root.left == null && root.right == null) {
      //leaf node, add to res if sky line change
      if(res.isEmpty()) {
        res.add(new int[] {func.get(root.start), root.count});
      } else {
        int[] preLine = res.get(res.size() - 1);
        if(preLine[1] != root.count) {
          res.add(new int[] {func.get(root.start), root.count});
        }
      }
      return;
    }

    if(root.lazyFlag == true) {
      if(root.left != null) {
        root.left.count = Math.max(root.count, root.left.count);
        root.left.lazyFlag = true;
      }
      if(root.right != null) {
        root.right.count = Math.max(root.count, root.right.count);
        root.right.lazyFlag = true;
      }
      root.lazyFlag = false;
    }

    getSkyLineResult(func, root.left, res);
    getSkyLineResult(func, root.right, res);
  }

  //Modify one node
  /*
  public void add(Node root, int index, int val) {
    //No intersection
    if(root.start > index|| root.end < index) {
      return;
    }

    //same
    if(root.start == index && root.end == index) {
      root.count += val;
      return;
    }

    //contain
    int mid = root.start + (root.end - root.start)/2;
    if(index <= mid) {
      add(root.left, index, val);
    } else {
      add(root.right, index, val);
    }


    root.count = root.left.count + root.right.count;
  }*/


  //Get count of a range
  public int query(Node node, int low, int high) {
    if (node == null || node.start > high || node.end < low) return 0;
    if (node.start >= low && node.end <= high) return node.count;
    return query(node.left, low, high) + query(node.right, low, high);
    /*
    if(root == null || root.start > end || root.end < start) {
      return 0;
    }
    if(root.start == start && root.end == end) {
      return root.count;
    }

    int mid = root.start + (root.end - root.start)/2;
    int left = query(root.left, start, Math.min(mid, end));
    int right = query(root.right, Math.max(mid + 1, start), end);

    return left + right;
    */
  }
}
