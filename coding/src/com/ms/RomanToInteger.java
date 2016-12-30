package com.ms;

import java.util.HashMap;

/**
 * Created by wangdong on 11/20/16.
 *
 * 从前往后扫描，用一个临时变量记录分段数字。
 如果当前比前一个大，说明这一段的值应该是当前这个值减去上一个值。比如IV = 5 – 1
 否则，将当前值加入到结果中，然后开始下一段记录。比如VI = 5 + 1， II=1+1
 */
public class RomanToInteger {
  public int romanToInt(String s) {
    HashMap<Character, Integer> romanInteger = new HashMap<>();
    romanInteger.put('I', 1);
    romanInteger.put('V', 5);
    romanInteger.put('X', 10);
    romanInteger.put('L', 50);
    romanInteger.put('C', 100);
    romanInteger.put('D', 500);
    romanInteger.put('M', 1000);

    int idx = 0;
    int res = 0;

    while (idx < s.length()) {
      //IV means 4
      //IVC means 94
      if(idx + 1 < s.length() && romanInteger.get(s.charAt(idx)) < romanInteger.get(s.charAt(idx+1))) {
        //if current < next roman
        res -= romanInteger.get(s.charAt(idx));
      } else {
        res += romanInteger.get(s.charAt(idx));
      }
      idx++;
    }

    return res;

  }
}
