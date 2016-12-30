package codeReview.dfsOrBfs;

/**
 * Created by wangdong on 7/5/16.
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0) {
      return 0;
    }
    int rows = grid.length;
    int columns = grid[0].length;
    int ans = 0;

    boolean[][] visited = new boolean[rows][columns];
    for(int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        visited[i][j] = false;
      }
    }

    //DFS
    for(int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if(grid[i][j] == '1' && visited[i][j] == false) {
          dfs(i, j, grid, visited);
          ans++;
        }
      }
    }

    return ans;
  }

  private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
    if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
      return;
    }
    if(visited[i][j] == true || grid[i][j] == '0') {
      return;
    }

    visited[i][j] = true;
    //left right up down
    dfs(i, j - 1, grid, visited);
    dfs(i, j + 1, grid, visited);
    dfs(i - 1, j, grid, visited);
    dfs(i + 1, j, grid, visited);
  }


}
