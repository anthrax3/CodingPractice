package codeReview.divideAndConquer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 3/2 = 1. for a, b, c the middle one is 2nd
        // 4/ 2 = 2, for a, b, c, d, the middle ones 2, 3
        int totalLength = (nums1.length + nums2.length);
        int middle = totalLength / 2;

        if(totalLength % 2 == 0) {
            //Even
            return  (findKthElement(nums1, 0, nums2, 0, middle) + findKthElement(nums1, 0, nums2, 0, middle + 1))/2.0;

        } else {
            return findKthElement(nums1, 0, nums2, 0, middle + 1);
        }

    }

    //K from 0 to arr1.size + arr2.size
    public static Integer findKthElement(int[] nums1, int startIdx1, int[] nums2, int startIdx2, int k) {
        if(startIdx1 >= nums1.length) {
            return nums2[startIdx2 + k - 1];
        }
        if(startIdx2 >= nums2.length) {
            return nums1[startIdx1 + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[startIdx1], nums2[startIdx2]);
        }

        int valueAtArray1 = nums1.length > startIdx1 + k/2 - 1 ? nums1[startIdx1 + k/2 - 1] : Integer.MAX_VALUE;
        int valueAtArray2 = nums2.length > startIdx2 + k/2 - 1 ? nums2[startIdx2 + k/2 - 1] : Integer.MAX_VALUE;

        //In each sub problems we delete partial points to make it smaller
        /*
        Assume there are array A, B
        if A have less than k/2 points, we an delete first k/2 B
        Reason: if K largest element in first half K B
        then even if plus all A points it is still less than K points, so it have to be in the second half B

        If A[K/2] < B[K/2]
        we can delete first half A
        Reason: if K largest in first half K at A, than it means more than half K points are in B, and all these points
        should smaller then the K largest, but B[K/2] > A[K/2] > K largest, which should not happen
         */

        //array2 less than K/2, remove first half of array1
        //A[mid] < B[mid] remove first half of array 1
        if(valueAtArray1 < valueAtArray2) {
            return findKthElement(nums1, startIdx1 + k/2,  nums2, startIdx2, k - k/2);
        } else {
            return findKthElement(nums1, startIdx1, nums2, startIdx2 + k/2, k - k/2);
        }
    }
}
