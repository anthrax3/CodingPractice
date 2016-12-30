package codeReview.graph;

import java.util.Stack;

/**
 * Created by wangdong on 10/9/16.
 */
public class LongestIncreasingPathInAMatrix {
  public int longestIncreasingPath(int[][] matrix) {
    if(matrix == null || matrix.length == 0) {
      return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    int[][] maxLengthAtNode = new int[rows][cols];
    int max = 0;

    for(int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++) {
        max = Math.max(max, dfs(matrix, row, col, maxLengthAtNode));
      }
    }

    return max;
  }

  private int dfs(int[][] matrix, int x, int y, int[][]maxLengthAtNode) {
    //Already visited
    if(maxLengthAtNode[x][y] != 0) {
      return maxLengthAtNode[x][y];
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int rows = matrix.length;
    int cols = matrix[0].length;

    for(int i = 0; i < 4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];

      if(nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && matrix[x][y] < matrix[nextX][nextY] ) {
        int nextNodeMaxLength = dfs(matrix, nextX, nextY, maxLengthAtNode);
        maxLengthAtNode[x][y] = Math.max(maxLengthAtNode[x][y], nextNodeMaxLength + 1);
      }
    }

    return maxLengthAtNode[x][y];
  }
}
