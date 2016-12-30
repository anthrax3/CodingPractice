package codeReview.Stack;

import java.util.Stack;

/**
 * Created by wangdong on 10/10/16.
 */
public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    if(tokens == null || tokens.length == 0) {
      return 0;
    }
    Stack<Integer> operands = new Stack<>();
    for(String token : tokens) {
      if (token.equals("+")) {
        int num = operands.pop();
        operands.push(operands.pop() + num);
      } else if (token.equals("-")) {
        int num = operands.pop();
        operands.push(operands.pop() - num);
      } else if (token.equals("*")) {
        int num = operands.pop();
        operands.push(operands.pop() * num);
      } else if (token.equals("/")) {
        int num = operands.pop();
        operands.push(operands.pop() / num);
      } else {
        operands.push(Integer.valueOf(token));
      }
    }

    return   operands.peek();
  }
}
