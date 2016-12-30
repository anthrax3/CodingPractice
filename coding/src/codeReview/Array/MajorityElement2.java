package codeReview.Array;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 7/21/16.
 * https://www.hrwhisper.me/leetcode-169-majority-element-leetcode-229-majority-element-ii/
 *
 *
 * 解法1: 排序, 统计次数 O(nlongN) + O(n)
 * 解法2: Hash O(n) 空间O(n)
 * 解法3: 摩尔投票, 最多两个 每个都超过1/3
 */

//find all elements that appear more than ⌊ n/3 ⌋ times
public class MajorityElement2 {
  public List<Integer> majorityElement(int[] nums) {
    if(nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    int a = 0;//any value as count is 0
    int countA = 0;

    int b = 1;
    int countB = 0;

    for(int num : nums) {
      if(num == a) {
        countA++;
      } else if(num == b) {
        countB++;
      } else if (countA == 0) {
        a = num;
        countA = 1;
      } else if (countB == 0) {
        b = num;
        countB = 1;
      } else {
        countA--;
        countB--;
      }
    }

    //Check each candidate
    List<Integer> res = new ArrayList<>();
    int checkA = 0;
    int checkB = 0;
    for(int num : nums) {
      if(num == a) {
        checkA++;
      }
      if (num == b) {
        checkB++;
      }
    }

    if(checkA > nums.length/3) {
      res.add(a);
    }
    if (checkB > nums.length/3) {
      res.add(b);
    }

    return res;
  }
}
