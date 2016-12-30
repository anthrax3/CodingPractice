package codeReview.string;

/**
 * Created by wangdong on 12/6/16.
 */
public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    if(s == null || t == null || s.equals(t) || Math.abs(s.length() - t.length()) > 1) {
      return false;
    }

    //String shortStr = s.length() <= t.length() ? s : t;
    //String longStr = s.length() > t.length() ? s : t;
    if(s.length() > t.length()) {
      return isOneEditDistance(t, s);
    }

    boolean edited = false;
    for(int i = 0, j = 0; i < s.length(); i++, j++) {
      if(s.charAt(i) != t.charAt(j)) {
        if(edited == true) {
          return false;
        }
        //do replace, continue
        edited = true;

        if(s.length() < t.length()) {
          //do insert at s, current i compare with next j
          //or do delete on j, current i comare to j+1
          i--;
        } else {
          //do replace,
        }
      }
    }

    return true;
  }
}
