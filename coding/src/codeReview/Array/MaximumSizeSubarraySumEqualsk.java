package codeReview.Array;

import java.util.HashMap;

/**
 * Created by wangdong on 12/19/16.
 */
public class MaximumSizeSubarraySumEqualsk {
  public int maxSubArrayLen(int[] nums, int k) {
    int max = 0;
    int sum = 0;
    HashMap<Integer, Integer> sumToSmallestIdx = new HashMap<>();

    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if(sum == k) {
        max = i;
      } else if (sumToSmallestIdx.containsKey(sum - k)){
        //check whether the sum[i] - sum[j] = k, then i - j is the new length
        max = Math.max(max, i - sumToSmallestIdx.get(sum - k));
      }

      //we may have several sum are same, but only the left most one get saved to hashmap
      if(!sumToSmallestIdx.containsKey(sum)) {
        sumToSmallestIdx.put(sum, i);
      }
    }

    return max;

  }
}
