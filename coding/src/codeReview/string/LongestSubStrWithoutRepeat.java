package codeReview.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdong on 10/12/16.
 */
public class LongestSubStrWithoutRepeat {
  public int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> preCharIdx = new HashMap<>();
    int max = 0;
    int curSubStrStartIdx = 0;

    for(int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);

      //the idx can be start idx or after start idx
      if(preCharIdx.containsKey(c) && preCharIdx.get(c) >= curSubStrStartIdx) {
        //already exist
        int preStringLength = i - curSubStrStartIdx;
        max = Math.max(preStringLength, max);

        //clean pre idx abba, current is new second b, clean the first a's index

        curSubStrStartIdx = preCharIdx.get(c) + 1;
      }
      preCharIdx.put(c, i);
    }

    max = Math.max(max, s.length() - curSubStrStartIdx);
    return max;
  }
}
