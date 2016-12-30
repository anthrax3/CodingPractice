package codeReview.DataStructure;

/**
 * https://www.hrwhisper.me/binary-indexed-tree-fenwick-tree/
 */
public class FenWickTree {
  private int n;
  private int[] sum;

  public FenWickTree(int size) {
    this.n = size;
    this.sum = new int[size];
  }

  //add one value, update logN nodes
  public void add(int index, int val) {
    while (index < n) {
      sum[index] += val;
      //Current node is left child node, move to its parent node
      index = index + lowBit(index);
    }
  }

  //Calculate sum, add up logN nodes
  public int sum(int index) {
    int res = 0;
    while (index > 0) {
      res += sum[index];
      //Index is the right child, move to parent (move to left up)
      index = index - lowBit(index);
    }

    return res;
  }

  private int lowBit(int x) {
    return x & -x;
  }
}
