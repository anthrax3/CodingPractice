package codeReview.UnionFound;

/**
 * Created by wangdong on 7/5/16.
 *
 * http://blog.csdn.net/dm_vincent/article/details/7655764
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0) {
      return 0;
    }

    int rows = grid.length;
    int columns = grid[0].length;

    UnionFind unionFind = new UnionFind(rows*columns);
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        if(grid[i][j] == '1') {
          //add top.left, right , down nodes if connected
          int currentIdx = i*columns + j;
          if(i - 1 > 0 && grid[i-1][j] == '1') {
            unionFind.union(currentIdx, currentIdx - columns);
          }
          if(i + 1 < rows && grid[i+1][j] == '1') {
            unionFind.union(currentIdx, currentIdx + columns);
          }
          if(j - 1 > 0 && grid[i][j-1] == '1') {
            unionFind.union(currentIdx, currentIdx - 1);
          }
          if(j + 1 < columns && grid[i][j+1] == '1') {
            unionFind.union(currentIdx, currentIdx + 1);
          }
        }
      }
    }

    return unionFind.getConnectedCount();
  }
}
