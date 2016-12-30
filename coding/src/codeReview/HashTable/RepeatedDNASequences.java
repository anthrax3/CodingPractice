package codeReview.HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * Created by wangdong on 10/15/16.
 */
public class RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    if(s == null || s.length() <= 10) {
      return new ArrayList<>();
    }

    HashSet<String> existing = new HashSet<>();
    Set<String> result = new HashSet<>();

    for(int i = 0; i <= s.length() - 10; i++) {
      String strToCheck = s.substring(i, i+10);
      if(existing.contains(strToCheck)) {
        result.add(strToCheck);
      } else {
        existing.add(strToCheck);
      }
    }

    return new ArrayList<>(result);
  }

}
