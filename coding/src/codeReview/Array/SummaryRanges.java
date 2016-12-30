package codeReview.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by wangdong on 7/20/16.
 */
public class SummaryRanges {
  private String getSum(int start, int end) {
    if(start == end) {
      return String.valueOf(start);
    } else {
      return String.format("%d->%d", start, end);
    }
  }

  public List<String> summaryRanges(int[] nums) {
    if(nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    List<String> res = new ArrayList<>();
    int start = nums[0];
    int end = nums[0];

    for(int i = 1; i < nums.length; i++) {
      if(nums[i] != end + 1) {
        res.add(getSum(start, end));
        start = nums[i];
        end = nums[i];
      } else {
        end = nums[i];
      }
    }
    res.add(getSum(start, end));

    return res;
  }
}
