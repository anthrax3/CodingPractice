package codeReview.DataStructure;

import java.util.Arrays;

/**
 * Created by wangdong on 5/30/16.
 * low <= sum[i to j] <= up
 * low <= sum[j] - sum[i-1] <= up
 * low + sum[i-1] <= sum[j] <= up + sum[i-1]
 * j > i-1
 * for each input sum[i] find all exist sum[j] that
 * low + sum_i <= sum[j] <= up + sum_i
 *
 * j should exist first, so from right to left
 */
public class CountOfRangeSum {
  public int countRangeSum(int[] nums, int lower, int upper) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int[] sum = new int[nums.length];
    sum[0] = nums[0];
    for(int i = 1; i < nums.length; i++) {
      sum[i] = sum[i-1] + nums[i];
    }

    //use total and nums[], we can regenerate nums in order
    int sumOfI = sum[nums.length - 1];

    Arrays.sort(sum);
    int unique = 0;

    for(int i = 0; i < sum.length - 1; i++) {
      if(sum[i] != sum[i+1]) {
        sum[unique] = sum[i];
        unique++;
      }
    }
    sum[unique] = sum[sum.length - 1];

    SegmentTree tree = new SegmentTree();
    //create segment tree based on sored sum
    //left right is based on the sum
    //sum looks like 1, 3, 4, 6, 7,10
    //the the range is sum range, based on the insert order to calculate value

    SegmentTree.Node root = tree.build(sum, 0, unique);

    int res = 0;

    /* for each input sum[i] find all exist sum[j] that
     *  low + sum_i <= sum[j] <= up + sum_i
     */

    for(int i = nums.length - 1; i >=0; i--) {
      //add previous checked one
      tree.add(root, sumOfI);
      //sum[i-1]
      sumOfI = sumOfI - nums[i];
      res += tree.query(root, lower + sumOfI, upper + sumOfI);
    }

    return res;
  }
}
