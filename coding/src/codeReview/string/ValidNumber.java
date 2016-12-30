package codeReview.string;

/**
 * Created by wangdong on 12/11/16.
 *
 *
 * Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true

 */

public class ValidNumber {
  public boolean isNumber(String s) {
    if(s == null) {
      return false;
    }

    if(s.trim().matches("[+,-]?(\\d+\\.?|\\.\\d+)\\d*(e[+,-]?\\d+)?")) {
      return true;
    } else {
      return false;
    }
  }
}
