package codeReview.BinarySearch;

/**
 * Created by wangdong on 6/2/16.
 * TODO end here
 */
public class FindMinimumInRotatedSortedArray2 {
  public int findMin(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    return helper(nums, 0, nums.length - 1);
  }

  public int helper(int[] nums, int start, int end) {
    if(start == end) {
      return nums[start];
    }

    while(start < end && nums[start] == nums[end]) {
      start++;
    }
    if(start == end) {
      return nums[start];
    }

    if(nums[start] < nums[end]) {
      return nums[start];
    } else {
      int mid = start + (end - start)/2;
      return Math.min(helper(nums, start, mid), helper(nums, mid+1, end));
    }
  }
}
