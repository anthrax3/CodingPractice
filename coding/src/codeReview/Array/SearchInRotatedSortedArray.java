package codeReview.Array;

/**
 * Created by wangdong on 11/7/16.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index,
 otherwise return -1


 */
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    if(nums == null || nums.length == 0) {
      return -1;
    }

    return helper(0, nums.length-1, nums, target);
  }

  private int binarySearch(int start, int end, int[] nums, int target) {
    //start can equal end
    while (start <= end) {
      int middle = start + (end - start)/2;
      if(nums[middle] < target) {
        start = middle+1;
      } else if(nums[middle] == target) {
        return middle;
      } else {
        end = middle-1;
      }
    }

    return -1;
  }

  private int helper(int start, int end, int[] nums, int target) {
    if(nums[start] <= nums[end]) {
      return binarySearch(start, end, nums, target);
    }

    int middle = start + (end - start)/2;
    int rest = helper(start, middle, nums, target);
    if(rest != -1) {
      return rest;
    }

    return helper(middle+1, end, nums, target);
  }
}
