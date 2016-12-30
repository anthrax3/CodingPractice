package com.ms;

/**
 * Created by wangdong on 11/20/16.
 */
public class ExcelSheetColumnTitle {
  public String convertToTitle(int n) {
    //1-26 to A..Z
    StringBuilder res = new StringBuilder();

    while (n > 0) {
      char cur = (char) ( (n-1)%26 + 'A');
      res.insert(0, cur);
      //if n = 26 => z, it should not have second character
      n = (n-1)/26;
    }

    return res.toString();
  }
}
