package codeReview.Math;

import java.util.HashMap;

/**
 * Created by wangdong on 10/16/16.
 */
public class FractionToRecurringDecimal {
  public String fractionToDecimal(int numerator, int denominator) {
    if(numerator == 0) {
      return "0";
    }

    StringBuilder result = new StringBuilder();
    long numeratorL = Long.valueOf(numerator);
    long denominatorL = Long.valueOf(denominator);

    if((numeratorL < 0)^(denominatorL<0)) {
      result.append("-");
    }

    numeratorL = Math.abs(numeratorL);
    denominatorL = Math.abs(denominatorL);

    result.append(numeratorL/denominatorL);

    long remain = numeratorL%denominatorL;
    if(remain == 0) {
      return result.toString();
    }
    result.append(".");

    HashMap<Long, Integer> numberIdx = new HashMap<>();

    while (remain != 0) {
      long newDigit = (remain*10)/denominatorL;
      remain = (remain*10)%denominatorL;

      if(numberIdx.containsKey(remain) &&
              newDigit == Integer.valueOf(String.valueOf(result.charAt(numberIdx.get(remain))))) {
        result.insert(numberIdx.get(remain), "(");

        result.append(")");
        return result.toString();
      }

      numberIdx.put(remain, result.length());
      result.append(newDigit);

    }

    return result.toString();
  }
}
