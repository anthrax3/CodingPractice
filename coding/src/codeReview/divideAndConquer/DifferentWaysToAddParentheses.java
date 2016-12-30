package codeReview.divideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdong on 5/22/16.
 */
public class DifferentWaysToAddParentheses {
    //Cut branch by adding cache
    private Map<String, List<Integer>> expressValue = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if(expressValue.containsKey(input)) {
            return expressValue.get(input);
        }
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            if('+' == input.charAt(i) || '-' == input.charAt(i) || '*' == input.charAt(i)) {
                List<Integer> leftRes = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightRes = diffWaysToCompute(input.substring(i + 1, input.length() ));

                for(Integer leftValue : leftRes) {
                    for (Integer rightValue : rightRes) {
                        if('+' == input.charAt(i)) {
                            res.add(leftValue + rightValue);
                        }
                        if('-' == input.charAt(i)) {
                            res.add(leftValue - rightValue);
                        }
                        if('*' == input.charAt(i)) {
                            res.add(leftValue * rightValue);
                        }
                    }
                }
            }
        }

        expressValue.putIfAbsent(input, res);
        //This input is a number, no operator
        if(res.isEmpty()) {
            res.add(Integer.valueOf(input));
        }

        return res;
    }
}
