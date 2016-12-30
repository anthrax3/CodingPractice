package com.ms;

/**
 * Created by wangdong on 11/19/16.
 */
public class ReverseWordsInAString {
  private void swap(char[] word, int start, int end) {
    while (start <= end) {
      char temp = word[end];
      word[end] = word[start];
      word[start] = temp;
    }
  }
  public String reverseWords(String s) {
    if(s == null || s.length() == 0) {
      return s;
    }

    char[] string = s.toCharArray();
    swap(string, 0, string.length-1);

    int start = 0;
    for(int i = 0; i <= s.length(); i++) {
      if(string[i] == ' ' || i == s.length()) {
        swap(string, start, i-1);
        start = i + 1;
      }
    }

    return String.valueOf(string);
  }
}
