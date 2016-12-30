package codeReview.Array;

/**
 * Created by wangdong on 11/13/16.
 *
 * Given a m x n matrix, if an element is 0,
 * set its entire row and column to 0. Do it in place.
 *
 * TODO
 * use the first row, first col as them memory to track zero status
 * as the first row and first column overlp in [0][0], track with separete flag
 */
public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {
    if(matrix == null) {
      return;
    }

    boolean firstRowZero = false;
    boolean firstColumnZero = false;

    int rows = matrix.length;
    int cols = matrix[0].length;

    for(int row = 0; row < rows; row++) {
      for(int col = 0; col < cols; col++) {
        if(matrix[row][col] == 0) {
          matrix[0][col] = 0;
          matrix[row][0] = 0;
          if(row == 0) {
            firstRowZero = true;
          }
          if(col == 0) {
            firstColumnZero = true;
          }
        }
      }
    }

    for(int row = 1; row < rows; row++) {
      for(int col = 1; col < cols; cols++) {
        if(matrix[0][col] == 0 || matrix[row][0] == 0) {
          matrix[row][col] = 0;
        }
      }
    }

    if(firstColumnZero) {
      for(int row = 0; row < rows; row++) {
        matrix[row][0] = 0;
      }
    }
    if(firstRowZero){
      for(int col = 0; col < cols; col++) {
        matrix[0][col] = 0;
      }
    }

    return;
  }
}
