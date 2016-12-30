package codeReview.UnionFound;

/**
 * Created by wangdong on 7/6/16.
 *
 * https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
 */
public class UnionFind {
  private int[] nodes;
  private int[] size;
  private int count;

  public UnionFind(int totalNodesNum) {
    nodes = new int[totalNodesNum];
    size = new int[totalNodesNum];
    count = totalNodesNum;
    for(int i = 0; i < totalNodesNum; i++) {
      //each node is a root
      nodes[i] = i;
      //tree size is 1
      size[i] = 1;
    }
  }
  private int root(int indexP) {
    while (nodes[indexP] != indexP) {
      //path compress, this node's previous node is its grand parent node
      nodes[indexP] = nodes[nodes[indexP]];
      //find root from grand parent node
      indexP = nodes[indexP];
    }

    return indexP;
  }

  public boolean find(int indexP, int indexQ) {
    int rootP = root(indexP);
    int rootQ = root(indexQ);

    if(rootP == rootQ) {
      return true;
    } else {
      return false;
    }
  }

  public void union(int indexP, int indexQ) {
    if(find(indexP, indexQ)) {
      return;
    }
    int rootP = root(indexP);
    int rootQ = root(indexQ);
    if(size[rootP] < size[rootQ]) {
      //use small tree as the subtree
      nodes[rootP] = rootQ;
      //update root size,
      size[rootQ] += size[rootP];

    } else {
      nodes[rootQ] = rootP;
      size[rootP] += size[rootQ];
    }
    count--;
  }

  public int getConnectedCount() {
    return count;
  }
}
