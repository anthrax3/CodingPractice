package codeReview.Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wangdong on 8/13/16.
 */
public class MinStack {
  int min = Integer.MAX_VALUE;
  Stack<Integer> stack;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int x) {
    stack.add(x);
    min = Math.min(x, min);
  }

  public void pop() {
    int pop = stack.pop();
    if(pop == min) {
      min = stack.stream().min(Integer::compare).orElse(Integer.MAX_VALUE);
    }
    return;
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }
}
