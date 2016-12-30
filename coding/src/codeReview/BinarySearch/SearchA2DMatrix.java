package codeReview.BinarySearch;

/**
 * Created by wangdong on 11/13/16.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchA2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    //O(n) search from top right to bottom right
    if(matrix == null) {
      return false;
    }

    int searchRow = 0;
    int searchCol = matrix[0].length - 1;

    while (searchRow < matrix.length && searchCol >= 0) {
      if(matrix[searchRow][searchCol] < target) {
        //move down, increase
        searchRow++;
      } else if(matrix[searchRow][searchCol] > target) {
        //move left, decrease
        searchCol--;
      } else {
        return true;
      }
    }

    return false;
  }
}
