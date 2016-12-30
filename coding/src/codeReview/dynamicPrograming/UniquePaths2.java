package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 11/13/16.
 */
public class UniquePaths2 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
      return 0;
    }

    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

    for(int row = 0; row < obstacleGrid.length; row++) {
      for(int col = 0; col < obstacleGrid[0].length; col++) {
        if(obstacleGrid[row][col] == 1) {
          dp[row][col] = 0;
        } else {
          if(row == 0 && col == 0) {
            dp[row][col] = 1;
          }

          if(col != 0) {
            dp[row][col] += dp[row][col-1];
          }
          if(row != 0) {
            dp[row][col] += dp[row-1][col];
          }
        }
      }
    }

    return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
  }
}
