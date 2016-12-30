package codeReview.dfsOrBfs;

import java.util.*;

/**
 * Created by wangdong on 12/20/16.
 */
public class RemoveInvalidParentheses {
  //recursivelly do dfs
  // for the a invalid string, to make it valid, we need either remove "(" or ")"
  // for each position i, we can take 2 actions
  // 1. keep the char at i
  // 2. remove the char at i

  // For the input string, we check how many left "(" and right ")" can be removed, dfs should stop it nothing can be removed
  // After remove the "(" if next char is not ")", then it not valid any more, stop dfs

  public List<String> removeInvalidParentheses(String s) {
    if(s == null || s.isEmpty()) {
      return Arrays.asList("");
    }

    int leftToRemove = 0;
    int rightToRemove = 0;

    for(char c : s.toCharArray()) {
      if(c == '(') {
        leftToRemove++;
      } else if(c == ')') {
        if(leftToRemove != 0) {
          leftToRemove--;
        } else {
          rightToRemove++;
        }
      }
    }

    Set<String> result = new HashSet<String> ();
    dfsRemove(s, 0, leftToRemove, rightToRemove, new StringBuilder(), 0, result);
    return new ArrayList<String>(result);
  }

  private void dfsRemove(String s, int curIdx, int leftToRemove, int rightToRemove, StringBuilder buffer, int openLeft, Set<String> result) {

    //System.out.println(String.format("buffer %s left %d, right %d, open %d", buffer.toString(), leftToRemove, rightToRemove, openLeft));

    if(leftToRemove < 0 || rightToRemove < 0 || openLeft < 0 ) {
      System.out.println("skip");
      //nothing can be remove or the current prefix already invalid, no further action needed
      return;
    }

    //all position are processed
    if(curIdx == s.length()) {
      //after process, the string is valid
      //System.out.println("finish");
      if(leftToRemove == 0 && rightToRemove == 0 && openLeft == 0) {
        result.add(buffer.toString());
        //System.out.println("add");
      }
      return;
    }

    //string is invalid, can remove '(' or ')'
    char curChar = s.charAt(curIdx);
    int beforeDfsSize = buffer.length();

    if(curChar == '(') {
      //keep current char
      //System.out.println("keep left");
      dfsRemove(s, curIdx+1, leftToRemove, rightToRemove, buffer.append(curChar), openLeft + 1, result);
      //remove left char
      buffer.setLength(beforeDfsSize);
      //System.out.println("remove left");
      dfsRemove(s, curIdx+1, leftToRemove - 1, rightToRemove, buffer, openLeft, result);
    } else if(curChar == ')') {
      //keep current char
      //System.out.println("keep right");
      dfsRemove(s, curIdx+1, leftToRemove, rightToRemove, buffer.append(curChar), openLeft - 1, result);
      //remove right char
      //TODO clean the buffer for next use
      buffer.setLength(beforeDfsSize);
      //System.out.println("remove right");
      dfsRemove(s, curIdx+1, leftToRemove, rightToRemove - 1, buffer, openLeft, result);
    } else {
      //not '(' or ')', continue
      dfsRemove(s, curIdx+1, leftToRemove, rightToRemove, buffer.append(curChar), openLeft, result);
    }

    //after dfs recover the buffer
    buffer.setLength(beforeDfsSize);
    return;
  }
}
