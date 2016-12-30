package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 11/13/16.
 */
public class MinimumPathSum {
  public int minPathSum(int[][] grid) {
    if(grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int[][] dpCurrentCellMinSum = new int[rows][cols];

    for(int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++) {
        if(row == 0 && col == 0) {
          dpCurrentCellMinSum[row][col] = grid[row][col];
        } else if(row == 0) {
          dpCurrentCellMinSum[row][col] = dpCurrentCellMinSum[row][col-1] + grid[row][col];
        } else if(col == 0) {
          dpCurrentCellMinSum[row][col] = dpCurrentCellMinSum[row-1][col] + grid[row][col];
         } else {
          dpCurrentCellMinSum[row][col] = Math.min(dpCurrentCellMinSum[row-1][col], dpCurrentCellMinSum[row][col-1]) + grid[row][col];
        }
      }
    }

    return dpCurrentCellMinSum[rows-1][cols-1];
  }
}
