package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 11/13/16.
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
 * in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the
 bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class UniquePaths {
  public int uniquePaths(int m, int n) {
    if(m == 0 || n == 0) {
      return 0;
    }

    int[][] dp = new int[m][n];

    //initialize first column, only 1 way (go down to get the cell)
    for(int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    for(int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }

    for(int row = 1; row < m; row++) {
      for(int col = 1; col < n; col++) {
        dp[row][col] = dp[row-1][col] + dp[row][col-1];
      }
    }

    return dp[m-1][n-1];
  }
}
