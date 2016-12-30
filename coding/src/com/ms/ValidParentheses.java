package com.ms;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by wangdong on 11/20/16.
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    if(s.isEmpty()) {
      return true;
    }

    Stack<Character> valid = new Stack<>();
    for(char parenthese : s.toCharArray()) {
      if(parenthese == '[' ||
        parenthese == '{' ||
        parenthese == '(') {
        valid.push(parenthese);
      } else {
        if(valid.isEmpty()) {
          return false;
        }
        char left = valid.pop();
        if((left == '(' && parenthese != ')') ||
          (left == '[' && parenthese != ']') ||
          (left == '{' && parenthese != '}')){
          return false;
        }
      }
    }

    return valid.isEmpty();
  }
}
