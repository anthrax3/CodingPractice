package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 7/18/16.
 */
public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int maxProdAtPreIndex = nums[0];
    int minProdAtPreIndex = nums[0];
    int ans = nums[0];


    for(int i = 1; i < nums.length; i++) {
      int maxWhenCurrentPositive = maxProdAtPreIndex * nums[i];
      int maxWhenCurrentNegative = minProdAtPreIndex * nums[i];

      maxProdAtPreIndex = Math.max(nums[i], Math.max(maxWhenCurrentPositive, maxWhenCurrentNegative));
      minProdAtPreIndex = Math.min(nums[i], Math.min(maxWhenCurrentPositive, maxWhenCurrentNegative));
      ans = Math.max(ans, maxProdAtPreIndex);
    }

    return ans;
  }
}
