package codeReview.BinarySearch;

/**
 * Created by wangdong on 7/3/16.
 */
public class ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    long start = 0;
    //Otherwise will exceed time limit
    long end = num/2 + 1;

    while (start <= end) {
      long mid = start + (end - start)/2;
      if(mid*mid > num) {
        end = mid - 1;
      } else if (mid*mid < num) {
        start = mid + 1;
      } else {
        return true;
      }
    }

    return false;
  }
}
