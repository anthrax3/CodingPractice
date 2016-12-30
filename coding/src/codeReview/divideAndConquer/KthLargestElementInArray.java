package codeReview.divideAndConquer;

/**
 * Created by wangdong on 5/17/16.
 */
public class KthLargestElementInArray {
    //Part of the quick sort
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
         //K largest, from end to front, Kth
        // if K = 1, first largest, means last element, which should be index length - 1
        return findInRange(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findInRange(int[] nums, int left, int right, int k) {
        if(left == right) {
            return nums[left];
        }

        int pivotIndex = partition1(nums, left, right);
        //K is the expected index
        if(pivotIndex == k) {
            return nums[pivotIndex];
        } else if(pivotIndex < k) {
            return findInRange(nums, pivotIndex + 1, right, k);
        } else {
            return findInRange(nums, left, pivotIndex - 1, k);
        }
    }

    //http://bubkoo.com/2014/01/12/sort-algorithm/quick-sort/
    //http://www.cnblogs.com/kkun/archive/2011/11/23/2260270.html

    public int partition1(int[] nums, int l, int r) {
        int pivot = nums[r];
        int storeIdx = l;

        for(int i = l; i < r; i++) {
            if(nums[i] < pivot) {
                //Move smaller element to front
                int temp = nums[storeIdx];
                nums[storeIdx] = nums[i];
                nums[i] = temp;
                storeIdx++;
            }
        }

        nums[r] = nums[storeIdx];
        nums[storeIdx] = pivot;
        return storeIdx;
    }

    public int partition2(int[] nums, int l, int r) {
        //Save left most element, then the left most position is empty, can be used to store other values
        int pivot = nums[l];

        while (l < r) {
            //Find not in place element from right, put it in the left empty space
            while (l < r && nums[r] > pivot) {
                r--;
            }
            //When find first r, put it in the left position, then this r position is empty
            nums[l] = nums[r];

            while (l < r && nums[l] <= pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        //previous loop exist when l = r, that position is empty
        nums[l] = pivot;
        return l;
    }
}
