package codeReview.BinarySearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wangdong on 7/3/16.
 */
public class MaxSumOfRectangleNoLargerThanK {
  private int binarySearchLowerBound(int[] arr, int startIdx, int endIdx, int key) {
    //find the smallest value that larger then or equal key
    int start = startIdx;
    int end = endIdx;
    while (start <= end) {
      int mid = start + (end - start);
      if(arr[mid] < key) {
        start = mid + 1;
      } else if(mid == key) {
        return mid;
      } else {
          end = mid - 1;
      }
    }

    if(start >= startIdx && start <= endIdx) {
      return start;
    } else {
      return -1;
    }

  }

  public int maxSumSubmatrix1(int[][] matrix, int k) {
    if(matrix == null || matrix.length == 0) {
      return 0;
    }
    //time complexisty is O(M^2 * Nlog(N)), smaller M do loop, larger N do binary search
    int rows = matrix.length;
    int columns = matrix[0].length;
    boolean loopRow = true;
    int m;
    int n;

    if(rows < columns) {
      m = rows;
      n = columns;
    } else {
      m = columns;
      n = rows;
      loopRow = false;
    }

    int ans = Integer.MIN_VALUE;

    for(int start = 0; start < m; start++) {
      //For retangle from start to end, length vary from 1 to n
      int[] cum = new int[n];
      for(int end = start; end < m; end++) {
        int sum = 0;
        //sums[0] = 0 means delete nothing, keep all
        int[] sums = new int[n+1];

        cum[0] = sum;
        for(int i = 0; i < n; i++) {
          //update accumulated matrix
          cum[i] += (loopRow ? matrix[end][i] : matrix[i][end]);
          sum += cum[i];
          //find sum[big] - sum[small] < K
          //find sum[small] > sum[big] - k -> find smallest sum[small]
          int toDelete = binarySearchLowerBound(sums, 0, i, sum - k);
          if(toDelete != -1) {
            ans = Math.max(ans, sum - sums[toDelete]);
          }

          sums[i+1] = sum;
        }
      }
    }

    return ans;
  }

  public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    //time complexisty is O(M^2 * Nlog(N)), smaller M do loop, larger N do binary search
    int rows = matrix.length;
    int columns = matrix[0].length;
    boolean loopRow = true;
    int m;
    int n;

    if (rows < columns) {
      m = rows;
      n = columns;
    } else {
      m = columns;
      n = rows;
      loopRow = false;
    }

    int ans = Integer.MIN_VALUE;

    for (int start = 0; start < m; start++) {
      //For retangle from start to end, length vary from 1 to n
      int[] cum = new int[n];
      for (int end = start; end < m; end++) {
        int sum = 0;
        TreeSet<Integer> sums = new TreeSet<>();

        for (int i = 0; i < n; i++) {
          //update accumulated matrix
          cum[i] += (loopRow ? matrix[end][i] : matrix[i][end]);
          sum += cum[i];
          if (sum <= k) {
            ans = Math.max(ans, sum);
          }
          Integer deleteSum = sums.ceiling(sum - k);
          if (deleteSum != null) {
            ans = Math.max(ans, sum - deleteSum);
          }

          sums.add(sum);
        }
      }
    }
    return ans;
  }

}
