package com.google;

import java.util.HashMap;

/**
 * Created by wangdong on 12/28/16.
 */
public class LongestAbsoluteFilePath {
  public int lengthLongestPath(String input) {
    if(input == null || !input.contains(".")) {
      return 0;
    }

    HashMap<Integer, Integer> depthLength = new HashMap<>();
    int max = 0;

    for(String s : input.split("\n")) {
      //if no \t, -1 will be returned
      int depth = s.lastIndexOf("\t") + 1;

      //update lenght of current depth
      int parentLenght = depthLength.containsKey(depth - 1) ? depthLength.get(depth - 1) : 0;
      String updated = s.replaceAll("\t", "");
      int currentDepthLength = parentLenght + updated.length() + 1;
      // \t\tabc will be changed to abc/ (abc.lenght() + 1), it need to add parent length
      depthLength.put(depth, currentDepthLength);

      if(s.contains(".") && currentDepthLength - 1 > max) {
        max = currentDepthLength - 1;
      }
    }

    return max;
  }
}
