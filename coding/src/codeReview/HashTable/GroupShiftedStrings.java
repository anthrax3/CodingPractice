package codeReview.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wangdong on 12/6/16.
 */
public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    HashMap<String, List<String>> patternList = new HashMap<>();

    for(String str : strings) {
      String pattern = "";
      for(int i = 1; i < str.length(); i++) {
        pattern += String.valueOf((26 + str.charAt(i) - str.charAt(i-1))%26);
      }

      patternList.putIfAbsent(pattern, new ArrayList<>());
      patternList.get(pattern).add(str);
    }

    return new ArrayList(patternList.values());
  }
}
