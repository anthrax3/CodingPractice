package codeReview.BinarySearch;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wangdong on 6/22/16.
 */

//http://stackoverflow.com/questions/7288585/building-bridges-problem-how-to-apply-longest-increasing-subsequence
public class LongestIncreasingSubsequence {
  //O(N^2)
  public int lengthOfLIS1(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }
    //dp[i] means longest increasing sequence include num[i]
    // the num[i] is the max number in this sequence
    int[] dp = new int[nums.length];
    dp[0] = 1;

    for(int i = 1; i < nums.length; i++) {
      //itself as a sequece has number 1
      dp[i] = 1;
      for(int j = 0; j < i; j++) {
        // 1 3 6 2 9 4
        //         |
        // 1 2 3 2
        // 2 3 4 3 4
        //           |
        // 2 3 X 3 X 3

        if(nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    return Arrays.stream(dp).max().getAsInt();
  }

  //https://www.felix021.com/blog/read.php?entryid=1587&page=1&part=1
  private int binarySearch(int[] smallestEndOfLengthLis, int startIdx, int endIdx, int key) {
    if(key > smallestEndOfLengthLis[endIdx]) {
      return endIdx + 1;
    } else if(key == smallestEndOfLengthLis[endIdx]) {
      return endIdx;
    } else if(key == smallestEndOfLengthLis[startIdx]) {
      return startIdx;
    }

    int start = startIdx;
    int end = endIdx;
    //find largest length end element that <= key (!!! can be equal, then update the equal one)
    while (start <= end) {
      int mid = start + (end - start)/2;
      if(key > smallestEndOfLengthLis[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    //finally arr[end] < key < arr[start]
    if(start > -1 && start <= endIdx) {
      return start;
    } else {
      //Should not happen as all ready did check at beginning
      return -1;
    }

  }

  public int lengthOfLIS(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int[] smallestEndValueOfEachLengthLIS = new int[nums.length + 1];
    int[] previousElement = new int[nums.length + 1];

    int maxLisLength = 1;
    smallestEndValueOfEachLengthLIS[1] = nums[0];

    for(int i = 0; i < nums.length + 1; i++) {
      //-1 means no previous value
      previousElement[i] = -1;
    }

    for(int i = 1; i < nums.length; i++) {
      int index = binarySearch(smallestEndValueOfEachLengthLIS, 1, maxLisLength, nums[i]);

      smallestEndValueOfEachLengthLIS[index] = nums[i];

      //track the original previous value of LSI length i
      previousElement[i] = smallestEndValueOfEachLengthLIS[index-1];

      if(index > maxLisLength) {
        maxLisLength = index;
      }
    }

    return maxLisLength;
  }
}
