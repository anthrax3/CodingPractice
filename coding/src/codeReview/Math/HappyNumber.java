package codeReview.Math;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by wangdong on 10/17/16.
 */
public class HappyNumber {
  public boolean isHappy(int n) {
    if(n == 0) {
      return false;
    }

    HashSet<Integer> appearedNum = new HashSet<>();
    appearedNum.add(n);
    while (n != 1) {
      int m = 0;
      while (n != 0) {
        int digit = n%10;
        n /= 10;
        m += digit*digit;
      }
      n = m;
      if(appearedNum.contains(n)) {
        break;
      } else {
        appearedNum.add(n);
      }
    }

    if(n == 1) {
      return true;
    } else {
      return false;
    }
  }
}
