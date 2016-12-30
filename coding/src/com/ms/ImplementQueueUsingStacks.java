package com.ms;

import java.util.Stack;

/**
 * Created by wangdong on 11/23/16.
 */
public class ImplementQueueUsingStacks {
  // Push element x to the back of queue.
  Stack<Integer> input = new Stack<>();
  Stack<Integer> output = new Stack<>();

  public void push(int x) {
    input.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
    if(output.size() == 0) {
      while (!input.isEmpty()) {
        output.push(input.pop());
      }
    }

    if(!output.isEmpty()) {
      output.pop();
    }
  }

  // Get the front element.
  public int peek() {
    if(output.size() == 0) {
      while (!input.isEmpty()) {
        output.push(input.pop());
      }
    }

    return output.peek();
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return input.isEmpty() && output.isEmpty();
  }
}
