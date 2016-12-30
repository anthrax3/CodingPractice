package codeReview.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 11/12/16.
 *
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 *
 * [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList<>();
    }

    List<Integer> res = new ArrayList<>();
    int left = 0;
    int right = matrix[0].length - 1;
    int top = 0;
    int bottom = matrix.length - 1;
    /*
     ----
     |  |
     ---|
     */
    while (left <= right || top <= bottom) {
      //top row (all)
      for(int i = left; i <= right; i++) {
          res.add(matrix[top][i]);
      }

      //add right(middle)
      for(int i = top+1; i <= bottom; i++) {
        res.add(matrix[i][right]);
      }

      //add bottom (all)
      if(bottom > top) {
        for(int i = right-1; i >= left; i--) {
          res.add(matrix[bottom][i]);
        }
      }


      //add left
      if(left < right) {
        for(int i = bottom-1; i > top; i--) {
          res.add(matrix[i][left]);
        }
      }

      left++;
      right--;
      top++;
      bottom--;
    }

    return res;
  }
}
