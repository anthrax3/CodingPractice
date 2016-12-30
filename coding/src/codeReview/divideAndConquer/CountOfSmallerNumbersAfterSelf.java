package codeReview.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 5/30/16.
 */
public class CountOfSmallerNumbersAfterSelf {
  public static class NumIdx {
    public int val;
    public int index;

    public NumIdx(int val, int index) {
      this.val = val;
      this.index = index;
    }

    public int getVal() {
      return val;
    }

    public int getIndex() {
      return index;
    }
  }
  public static List<Integer> countSmaller(int[] nums) {
    List<Integer> res =  new ArrayList<>();
    if(nums == null || nums.length == 0) {
      return res;
    }

    List<NumIdx> numbers = new ArrayList<>();
    for(int i = 0; i < nums.length; i++) {
      numbers.add(new NumIdx(nums[i], i));
    }

    int[] smaller = new int[nums.length];
    sort(numbers, smaller);

    for(int count : smaller) {
      res.add(count);
    }

    return res;

  }

  public static List<NumIdx> sort(List<NumIdx> nums, int[] smaller) {
    if(nums.size() < 2) {
      return nums;
    }
    int mid = nums.size() / 2;
    List<NumIdx> left = sort(nums.subList(0, mid), smaller);
    List<NumIdx> right = sort(nums.subList(mid, nums.size()), smaller);

    List<NumIdx> merged = new ArrayList<>();
    int leftIdx = 0;
    int rightIdx = 0;
    int jumpToLeftCount = 0;

    while(leftIdx < left.size() || rightIdx < right.size()) {
      //use left
      if(rightIdx == right.size() || (leftIdx < left.size() && left.get(leftIdx).getVal() <= right.get(rightIdx).getVal()) ) {
        //Here is += the smaller[i] can be updated in different recursion
        smaller[left.get(leftIdx).getIndex()] += jumpToLeftCount;
        merged.add(left.get(leftIdx));
        leftIdx++;
      } else {
        merged.add(right.get(rightIdx));
        rightIdx++;
        jumpToLeftCount++;
      }
    }

    return merged;
  }
}
