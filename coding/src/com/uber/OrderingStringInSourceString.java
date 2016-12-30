package com.uber;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by wangdong on 9/27/16.
 */
public class OrderingStringInSourceString {
  public boolean isContain(String source, String order) {
    if(StringUtils.isBlank(source) && StringUtils.isNoneBlank(order)) {
      return false;
    }

    HashMap<Integer, Pair<Integer, Integer>> charFirstLastIdxInSource = new HashMap<>();
    int idx = 0;
    for(char character : source.toCharArray()) {
      int charIndex = (int)character;
      charFirstLastIdxInSource.putIfAbsent(charIndex, Pair.of(idx, idx));
      Pair<Integer, Integer> startEndIdx = charFirstLastIdxInSource.get(charIndex);
      if(startEndIdx.getRight() < idx) {
        charFirstLastIdxInSource.put(charIndex, Pair.of(startEndIdx.getLeft(), idx));
      }
      idx++;
    }

    for(int i = 0; i < order.length() - 1; i++) {
      int currentCharIdx = (int)order.charAt(i);
      int nextCharIdx = (int)order.charAt(i+1);
      if(charFirstLastIdxInSource.get(currentCharIdx).getRight() > charFirstLastIdxInSource.get(nextCharIdx).getLeft()) {
        return false;
      }
    }

    return true;
  }
}
