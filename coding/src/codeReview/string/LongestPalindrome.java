package codeReview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdong on 10/8/16.
 */
public class LongestPalindrome {
  public int longestPalindrome(String s) {
    if(s == null || s.isEmpty()) {
      return 0;
    }

    HashMap<Integer, Integer> charQuantity = new HashMap<>();
    for(char c : s.toCharArray()) {
      charQuantity.putIfAbsent((int)c, 0);
      int updatedQuantity = charQuantity.get((int)c) + 1;
      charQuantity.put((int)c, updatedQuantity);
    }

    int pairQuantity = 0;
    boolean extraChar = false;

    for(Map.Entry<Integer, Integer> charNum : charQuantity.entrySet()) {
      pairQuantity += charNum.getValue()/2;
      if(extraChar == false && charNum.getValue()%2 == 1) {
        extraChar = true;
      }
    }

    return pairQuantity*2 + (extraChar ? 1 : 0);
  }
}
