package codeReview.Math;

/**
 * Created by wangdong on 10/17/16.
 */
public class ColumnTitle {
  public int titleToNumber(String s) {
    if(s.isEmpty()) {
      return 0;
    }

    int total = 0;
    for(char digit : s.toCharArray()) {
      int cur = (digit - 'A') + 1;
      total = total * 26 + cur;
    }

    return total/26;
  }
}
