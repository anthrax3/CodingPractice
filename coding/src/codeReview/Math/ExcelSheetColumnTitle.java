package codeReview.Math;

/**
 * Created by wangdong on 10/16/16.
 */
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    if(n == 0) {
      return "";
    }

    StringBuilder builder = new StringBuilder();
    while (n > 0) {
      char end = (char)('A' + (n-1)%26);
      builder.insert(0, end);

      // 26 - 1 = 25 => Z
      // 1 - 1 = 0 => A
      n = (n-1) / 26;
    }

    return builder.toString();
  }
}
