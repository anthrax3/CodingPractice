package com.ms;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * Created by wangdong on 11/15/16.
 */
public class IntegerToEnglishWords {
  private String convertHundred(int num) {
    String[] v1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] v2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
            "Eighty", "Ninety"};

    int a = num/100;
    int b = num%100;
    int c = num%10;

    String res;
    // "Eleven"
    // "Twenty one"
    // "Twenty"
    res = b < 20 ? v1[b] : v2[b/10]  +  (c > 0 ? " " + v1[c] : "");
    if(a > 0) {
      res = v1[a] + " " + "Hundred" + (b > 0 ? " " + res : "");
    }

    return res;
  }
  public String numberToWords(int num) {
    String res = convertHundred(num % 1000);
    String[] v = {"Thousand", "Million", "Billion"};
    for (int i = 0; i < 3; ++i) {
      num /= 1000;
      res = num % 1000 > 0 ? convertHundred(num % 1000) + " " + v[i] + " " + res : res;
    }
    if(res.endsWith(" ")) {
      res = res.substring(0, res.length()-1);
    }
    return res.isEmpty() ? "Zero" : res;
  }
}
