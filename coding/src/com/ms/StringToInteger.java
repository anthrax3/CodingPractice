package com.ms;

/**
 * Created by wangdong on 11/20/16.
 */
public class StringToInteger {
  public int myAtoi(String str) {
    if(str == null || str.isEmpty()) {
      return 0;
    }

    str = str.trim();

    long rest = 0;
    boolean positive = true;
    int index = 0;

    //only the first sign is valid
    //if see -+134 should return 0
    if(str.charAt(index) == '-') {
      positive = false;
      index++;
    } else if(str.charAt(index) == '+') {
      index++;
    }


    while (index < str.length()) {
      if(str.charAt(index) < '0' || str.charAt(index) > '9') {
        //special char
        break;
      }

      rest = rest*10 + (str.charAt(index) - '0');

      //cut branch
      if(rest > (long)Integer.MAX_VALUE) {
        break;
      }
      index++;
    }

    if(positive == false) {
      rest = -rest;
    }

    if(rest >= (long) Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if(rest <= (long)Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    } else {
      return (int)rest;
    }
  }
}
