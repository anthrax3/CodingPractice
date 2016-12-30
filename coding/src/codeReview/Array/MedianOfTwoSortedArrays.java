package codeReview.Array;

/**
 * Created by wangdong on 8/5/16.
 *
 *简单思路: merge sort, 找到 n/2 n 为奇数 , 或者 (n/2+ n/2 - 1)/2.0 n为偶数
 * O(n) 时间复杂度, 空间复杂度 O(n)
 *
 *
 * 提高: compare median
 * array m
 * array n
 *
 * recursive
 *
 * if median(n) == median(m) =》 find
 * if median(n) 《 median(m)  find in second of n and first of m
 * if median(n) 》 median(m)  find in first on n and and second of m
 *
 * o(log(min(m, n)))
 * Find Median
 *
 *
 * 转换到从两个array中找第k个
 */

public class MedianOfTwoSortedArrays {
  private double getMedianByIndex(int[] nums, int start, int end) {
    int length = end - start + 1;
    int middle = start + (end - start)/2;
    if(length%2 == 1) {
      return nums[middle];
    } else {
      return (nums[middle+1] + nums[middle])/2.0;
    }
  }

  private int getMiddleLeftIdx(int start, int end) {
      return start + (end - start)/2;
  }

  private int getMiddleRightIdx(int start, int end) {
    if((end-start+1) %2 == 0) {
      //even 0, 1 => middle is 0, right start from 1
      return start + (end - start)/2 + 1;

    } else {
      return start + (end - start)/2;
    }
  }

  public double findMedianSortedArraysHelper(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
    //the short array first run out
    if(start1 > end1) {
      return getMedianByIndex(nums2, start2, end2);
    }
    if(start2 > end2) {
      return getMedianByIndex(nums2, start2, end2);
    }
    if(end1 - start1 == 1 && end2 - start2 == 1) {
      return (nums1[start1] + nums2[start2])/2.0;
    }

    double medianOf1 = getMedianByIndex(nums1, start1, end1);
    double medianOf2 = getMedianByIndex(nums2, start2, end2);

    if(medianOf1 == medianOf2) {
      return medianOf1;
    } else if(medianOf1 < medianOf2) {
      //second of 1 and first of 2
      return findMedianSortedArraysHelper(nums1, getMiddleRightIdx(start1, end1), end1, nums2, start2, getMiddleLeftIdx(start2, end2));
    } else {
      //first of 1, second of 2
      return findMedianSortedArraysHelper(nums1, start1, getMiddleLeftIdx(start1, end1), nums2, getMiddleRightIdx(start2, end2), end2);
    }
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    return findMedianSortedArraysHelper(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
  }
}
