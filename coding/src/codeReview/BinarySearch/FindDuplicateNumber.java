package codeReview.BinarySearch;

/**
 * Created by wangdong on 6/20/16.
 *
 * complexity < O(N^2), O(1) space
 *
 * more number in the range
 * 1 ~ n -> num[N+1]
 */
public class FindDuplicateNumber {
  public int findDuplicate(int[] nums) {
    int low = 1;//1
    int high = nums.length - 1;//N, nums has N+1 elements
    while(low <= high) {
      //chose a supposed duplicate number to check
      int mid = low + (high - low)/2;

      int lessOrEqualToMidNum = 0;
      for(int num : nums) {
        if(num <= mid) {
          lessOrEqualToMidNum++;
        }
      }
      //From 1 ~ N/2 (index 0 ~ mid-1, which has mid count number, the max <= mid count in this range is mid, 1, 2,...mid), there are more than n/2 number <= N/2, then the
      //duplicate is in 1 ~ N/2
      if(lessOrEqualToMidNum > mid) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }

  public int findDuplicateInNTime(int[] nums) {
    int slow = nums[0];
    int fast = nums[nums[0]];
    while(slow != fast) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }

    //when meet, move slow to start, move in same pace, find the meet point
    slow = 0;
    while(slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;

  }
}
