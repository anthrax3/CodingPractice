package codeReview.Array;

/**
 * Created by wangdong on 11/11/16.
 *
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    int n = matrix.length;
    int top = 0;
    int left = 0;
    int bottom = n - 1;
    int right = n - 1;

    while (n > 0) {
      //for(int i = 0; i < n; i++) {
      for(int i = 0; i < n-1; i++) {
        //TODO i is the offset should not equal to n-1,
        //使用n来记录每一圈的边长。一圈进行4次操作，每次操作移动n - 1个元素即可
        // 4*4 one outside circle is 12 elements
        /*
          -----|
          |    |  each is n-1 instead n
          |-----

         */

        //int temp = matrix[top][i];
        int temp = matrix[top][left+i];
        //matrix[top][i] = matrix[n-i-1][left];
        matrix[top][left+i] = matrix[bottom-i][left];
        //matrix[n-i-1][left] = matrix[bottom][n-i-1];
        matrix[bottom-i][left] = matrix[bottom][right-i];
        //matrix[bottom][n-i-1] = matrix[i][right];
        matrix[bottom][right-i] = matrix[top+i][right];
        //matrix[i][right] = temp;
        matrix[top+i][right] = temp;
      }
      top++;
      left++;
      bottom--;
      right--;
      n -= 2;
    }

    return;
  }
}
