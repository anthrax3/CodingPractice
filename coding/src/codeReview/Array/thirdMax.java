package codeReview.Array;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by wangdong on 10/29/16.
 */
public class thirdMax {
  public int thirdMax(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    long max = Long.MIN_VALUE;
    long middle = Long.MIN_VALUE;
    long low = Long.MIN_VALUE;

    for(int num : nums) {
      if(num > max) {
        low = middle;
        middle = max;
        max = num;
      } else if (num > middle && num < max) {
        low = middle;
        middle = num;
      } else if(num > low && num < middle) {
        low = num;
      }
    }

    if(low != Long.MIN_VALUE) {
      return (int)low;
    } else {
      return (int)max;
    }
  }
}
