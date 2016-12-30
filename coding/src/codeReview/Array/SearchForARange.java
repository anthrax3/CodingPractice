package codeReview.Array;

/**
 * Created by wangdong on 11/7/16.
 *
 * Given a sorted array of integers, find the starting and
 * ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].


 */
public class SearchForARange {

  public int[] searchRange(int[] nums, int target) {
    if(nums.length == 0 || target < nums[0] || target > nums[nums.length-1]) {
      return new int[] {-1, -1};
    }

    int[] res = new int[2];
    int start = 0;
    int end = nums.length - 1;

    //find the left boundry
    while (start < end) {
      int mid = start + (end-start)/2;
      if (nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    if(nums[start] == target) {
      res[0] = start;
    } else {
      return new int[] {-1, -1};
    }


    start = 0;
    end = nums.length -1;
    //find the right boundry
    while (start < end) {
      int mid = start + (end-start)/2 + 1;
      if (nums[mid] > target) {
        end = mid - 1;
      } else {
        start = mid;
      }
    }

    res[1] = end;

    return res;
  }

}
