package codeReview.string;

import codeReview.Utilities.NestedInteger;

import java.util.Stack;

/**
 * Created by wangdong on 10/8/16.
 */


/*String is non-empty.
  String does not contain white spaces.
  String contains only digits 0-9, [, - ,, ].
*/

public class MiniParser {
  public NestedInteger deserializeStack(String s) {
    Stack<NestedInteger> nestedLists = new Stack<>();

    NestedInteger current = null;
    Integer num = null;
    boolean positive = true;
    if(s.charAt(0) != '[') {
      return new NestedInteger(Integer.valueOf(s));
    }

    for(char c : s.toCharArray()) {
      if(c == '[') {
        if (current != null) {
         nestedLists.push(current);
        }
        current = new NestedInteger();
        positive = true;
        num = null;
      } else if(c == ',' || c == ']') {
        if(num != null) {
          current.add(new NestedInteger(num*(positive ? 1 : -1)));
        }

        positive = true;
        num = null;
        if(c == ']' && !nestedLists.isEmpty()) {
            nestedLists.peek().add(current);
            current = nestedLists.pop();
        }
      } else if (c == '-') {
        positive = false;
      } else {
        //number
        if (num == null) {
          num = 0;
        }
        num = num*10 + (c - '0');
      }
    }

    return current;
  }

  public NestedInteger deserializeRecursive(String s) {
    if(s.isEmpty()) {
      return new NestedInteger();
    }
    if(s.charAt(0) != '[') {
      return new NestedInteger(Integer.valueOf(s));
    }
    if(s.length() <= 2) {
      return new NestedInteger();
    }

    int layerDiff = 0;
    int preStart = 1;

    NestedInteger res = new NestedInteger();
    for(int i = 1; i < s.length(); i++) {
      char currentChar = s.charAt(i);

      //do insert when see a new "," and in same layer
      //or at the end of string [ {} (])
      if((currentChar == ',' || i == s.length() - 1) && layerDiff == 0 ) {
        res.add(deserializeRecursive(s.substring(preStart, i)));
        preStart = i+1;
      }
      else if(currentChar == '[') {
        layerDiff++;
      }
      else if(currentChar == ']') {
        layerDiff--;
      }
    }

    return res;
  }
}
