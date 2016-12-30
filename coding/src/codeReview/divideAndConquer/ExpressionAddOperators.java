package codeReview.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 5/22/16.
 */
public class ExpressionAddOperators {
    private final static char EMPTY_OPERATOR = 'N';
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(0, "", 1, num, EMPTY_OPERATOR, target, res);

        return res;
    }

    public static void helper(long preValue, String preStringWithOperator, long diff, String remainingNum, char operator, int target, List<String> res) {
        long diffWithCurrentOperator = 0;
        for(int numLength = 1; numLength <= remainingNum.length(); numLength++) {
            String currNum = remainingNum.substring(0, numLength);
            if(currNum.length() > 1 && currNum.charAt(0) == '0') {
                //Other longer num will also start from 0, should return, this part can only choose 0 */-/+
                return;
            }

            long currIntNum = Long.valueOf(currNum);
            long currTotal = 0;

            if(operator == '+') {
                currTotal = preValue + currIntNum;
                diffWithCurrentOperator = currIntNum;//之前重用了传入的diff导致出错
            }
            if(operator == '-') {
                currTotal = preValue - currIntNum;
                diffWithCurrentOperator = -currIntNum;
            }
            if(operator == '*') {
                currTotal = (preValue - diff) + diff * currIntNum;
                diffWithCurrentOperator = diff*currIntNum;//如果重用,这乘的diff是上面条件改后的diff, 不是原始传入的值
            }
            if(operator == EMPTY_OPERATOR) {
                currTotal = currIntNum;
                diffWithCurrentOperator = currIntNum;
            }

            String currentExpress = preStringWithOperator + currNum;

            if(numLength == remainingNum.length()) {
                if(currTotal == target) {
                    res.add(currentExpress);
                }
                return;
            } else {
                helper(currTotal, currentExpress + "+", diffWithCurrentOperator, remainingNum.substring(numLength), '+', target, res);
                helper(currTotal, currentExpress + "-", diffWithCurrentOperator, remainingNum.substring(numLength), '-', target, res);
                helper(currTotal, currentExpress + "*", diffWithCurrentOperator, remainingNum.substring(numLength), '*', target, res);
            }
        }
    }
}
