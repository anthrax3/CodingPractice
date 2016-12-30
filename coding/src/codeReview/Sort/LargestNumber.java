package codeReview.Sort;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Created by wangdong on 10/15/16.
 *
 * TODO contact to integer to compare
 */
public class LargestNumber {

  public String largestNumber(int[] nums) {
    if(nums == null) {
      return "0";
    }
    //sort from big to small
    String res = IntStream.of(nums).boxed().sorted(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        String num1 = String.valueOf(o1).concat(String.valueOf(o2));
        String num2 = String.valueOf(o2).concat(String.valueOf(o1));

        return -(Long.valueOf(num1).compareTo(Long.valueOf(num2)));
      }
    }).map(num -> String.valueOf(num))
    .reduce(String::concat).orElse("0");

    if(res.length() > 1 && res.startsWith("0")) {
      res =  res.replaceFirst("^0*", "");
      if(res.isEmpty()) {
        return "0";
      } else {
        return res;
      }
    } else {
      return res;
    }
  }
}
