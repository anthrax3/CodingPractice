package codeReview.backtracking;

import java.util.HashMap;

/**
 * Created by wangdong on 12/5/16.
 */
public class WordPattern2 {
  public boolean wordPatternMatch(String pattern, String str) {
    if(pattern == null) {
      return false;
    }
    if(pattern.isEmpty() && str.isEmpty()) {
      return true;
    }

    HashMap<Character, String> patternStr = new HashMap<>();

    return  helper(patternStr, pattern, str, 0, 0);
  }

  private boolean helper(HashMap<Character, String> patternStr, String pattern, String str, int patternIdx, int strIdx) {
    //do check
    if(patternIdx == pattern.length() && strIdx == str.length()) {
      //matched to last element
      return true;
    }

    if(patternIdx >= pattern.length() || strIdx >= str.length()) {
      //one reach the last element
      return false;
    }

    char p = pattern.charAt(patternIdx);

    for(int nextStrIdx = strIdx + 1; nextStrIdx <= str.length(); nextStrIdx++) {
      String pStr = str.substring(strIdx, nextStrIdx);
      //System.out.println("p = " + String.valueOf(p) + " pattern s " + pStr);

      if(patternStr.containsKey(p) && patternStr.get(p).equals(pStr)) {
        //this pattern alreay happened before
        //System.out.println("Contain, p idx" + patternIdx+1 + " next s idx " + nextStrIdx);
        if(helper(patternStr, pattern, str, patternIdx+1, nextStrIdx)) {
          return true;
        }
      } else if (!patternStr.containsKey(p) && !patternStr.containsValue(pStr)) {
        //pattern not exist, not other pattern use this str
        patternStr.put(p, pStr);
        if(helper(patternStr, pattern, str, patternIdx+1, nextStrIdx)) {
          return true;
        }
        patternStr.remove(p);
      }// else use next pattern str
    }

    return false;
  }
}
