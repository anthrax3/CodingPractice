package com.ms;

/**
 * Created by wangdong on 11/15/16.
 *
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if(m == 0 || n == 0) {
      return;
    }
    int nIdx = n-1;
    int mIdx = m-1;
    int idx = m+n-1;

    while (nIdx >= 0 && mIdx >= 0) {
      if(nums1[mIdx] > nums2[nIdx]) {
        nums1[idx--] = nums1[mIdx--];
      } else {
        nums1[idx--] = nums2[nIdx--];
      }
    }

    while (nIdx >= 0) {
      nums1[idx--] = nums2[nIdx--];
    }
    while (mIdx >= 0) {
      nums1[idx--] = nums1[mIdx--];
    }
    return;
  }
}
