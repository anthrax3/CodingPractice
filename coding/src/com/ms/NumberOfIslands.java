package com.ms;

/**
 * Created by wangdong on 11/15/16.
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int count = 0;
    boolean[][] visited = new boolean[rows][cols];

    for(int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if(grid[row][col] == '1' && visited[row][col] == false) {
          dfs(grid, visited, row, col);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, boolean[][] visited, int row, int col) {
    /*
    if(visited[row][col] == false ||
            row < 0 ||
            row >= grid.length ||
            col < 0 ||
            col >= grid[0].length) {
      return;
    }*/
    if( row < 0 ||
            row >= grid.length ||
            col < 0 ||
            col >= grid[0].length ||
            visited[row][col] == true) {
      return;
    }

    visited[row][col] = true;

    if(grid[row][col] == '1') {
      dfs(grid, visited, row-1, col);
      dfs(grid, visited, row+1, col);
      dfs(grid, visited, row, col-1);
      dfs(grid, visited, row, col+1);
    }
    return;
  }
}
