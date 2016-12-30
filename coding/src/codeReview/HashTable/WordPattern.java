package codeReview.HashTable;

import java.util.HashMap;

/**
 * Created by wangdong on 12/5/16.
 */
public class WordPattern {
  public boolean wordPattern(String pattern, String str) {
    if(pattern == null) {
      return false;
    }

    HashMap<Character, Integer> patternIdx = new HashMap();
    HashMap<String, Integer> strIdx = new HashMap();

    char[] patterns = pattern.toCharArray();
    String[] strs = str.split(" ");

    if(patterns.length != strs.length) {
      return false;
    }


    for(int i = 0; i < patterns.length; i++) {
      patternIdx.putIfAbsent(patterns[i], i);
      strIdx.putIfAbsent(strs[i], i);

      //TODO Integer is object, should use equals
      if(!patternIdx.get(patterns[i]).equals(strIdx.get(strs[i]))){
        return false;
      }
    }

    return true;

  }
}
