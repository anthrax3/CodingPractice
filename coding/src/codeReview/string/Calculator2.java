package codeReview.string;

import java.util.Set;
import java.util.Stack;

/**
 * Created by wangdong on 5/6/16.
 */
public class Calculator2 {
    public static int calculate(String s) {
        char[] chars = s.toCharArray();

        Integer accumulatedPreNumber = null;
        Integer currentNum = 0;
        boolean positive = true;
        Integer result = 0;
        String previousOperation = null;



        for(int i = 0; i < chars.length; i++) {
            if('0' <= chars[i] && chars[i] <= '9') {
                currentNum = currentNum * 10 + (chars[i] - '0');
            }

            if(chars[i] == '+' || chars[i] == '-' || i == chars.length - 1) {
                //Add current to result set, update sign of next integer
                if(previousOperation != null) {
                    currentNum = previousOperation.equals("*")  ? accumulatedPreNumber * currentNum : accumulatedPreNumber / currentNum;
                    previousOperation = null;
                }
                result = addCurrentToResult(result, currentNum, positive);
                positive = chars[i] == '+' ? true : false;
                accumulatedPreNumber = null;
                currentNum = 0;
            }

            if(chars[i] == '*' || chars[i] == '/') {
                if(accumulatedPreNumber == null) {
                    accumulatedPreNumber = currentNum;
                    currentNum = 0;
                } else if (previousOperation != null) {
                    accumulatedPreNumber = (previousOperation.equals("*") ? accumulatedPreNumber * currentNum : accumulatedPreNumber / currentNum);
                    currentNum = 0;
                }

                previousOperation = String.valueOf(chars[i]);
            }

        }

        return result;
    }

    private static int addCurrentToResult(int result, int currentNum, boolean positive) {
        return positive == true ? (result + currentNum) : (result - currentNum);
    }
}
