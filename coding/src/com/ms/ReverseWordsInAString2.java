package com.ms;

/**
 * Created by wangdong on 11/15/16.
 *
 * Given an input string, reverse the string word by word.
 * A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces
 and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */
public class ReverseWordsInAString2 {
  //1. reverse whole string
  //2. reverse each word
  private void swap(char[] s, int start, int end) {
    while (start <= end) {
      char temp = s[end];
      s[end] = s[start];
      s[start] = temp;
      start++;
      end--;
    }
    return;
  }
  public void reverseWords(char[] s) {
    if(s == null || s.length == 0) {
      return;
    }
    int start = 0;
    int end = s.length - 1;

    swap(s, start, end);
    int startOfWord = 0;
    int endOfWord = 0;
    while (endOfWord < s.length) {
      if(s[endOfWord] == ' ' || endOfWord == s.length-1) {
        if(endOfWord == s.length-1) {
          endOfWord = endOfWord+1;
        }
        swap(s, startOfWord, endOfWord-1);
        startOfWord = endOfWord+1;
      }
      endOfWord++;

    }

    return;
  }

}
