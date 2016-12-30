package codeReview.greedy;

/**
 * Created by wangdong on 5/17/16.
 */
public class MaximumSubarray{
        public int maxSubArray1(int[] nums) {
            if(nums == null || nums.length == 0) {
                return 0;
            }

            int sum = 0;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                //maybe sum become smaller, then keep old max value for this point
                max = Math.max(max, sum);
                //If sum < 0, we should start a new sub array
                sum = Math.max(sum, 0);
            }

            return max;
        }

        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0) {
                return 0;
            }

            int sum = 0;
            int preMinSum = 0;
            //Sub array = sum - preMinSum
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                max = Math.max(sum - preMinSum, max);
                preMinSum = Math.min(sum, preMinSum);
            }

            return max;
        }
}
