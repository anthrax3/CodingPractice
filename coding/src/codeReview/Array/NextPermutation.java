package codeReview.Array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by wangdong on 11/7/16.
 * Implement next permutation, which rearranges numbers into the lexicographically
 * next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order
 (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs
 are in the right-hand column.


 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class NextPermutation {

  //1, 找到一个index K, K之后的序列递减
  //2, 找到递减序列中大于 num[K] 的最小值
  //3. 交换num[K] 和 最小值
  //4, 对index K后的序列反转变为升序
  public void nextPermutation(int[] nums) {
    if(nums == null || nums.length == 0) {
      return;
    }

    //find k, after k the num decrease one by one
/*
    int decreaseStart = nums.length - 2;
    while (decreaseStart >= 0) {
      if(nums[decreaseStart] > nums[decreaseStart+1]) {
        decreaseStart--;
      }
    }
*/
    int decreaseStart = -1;
    for(int i = nums.length - 2; i >= 0; i--) {
      if(nums[i] < nums[i+1]) {
        decreaseStart = i;
        break;
      }
    }

    if(decreaseStart < 0) {
      //current is max
      reverse(nums, 0, nums.length-1);
      return;
    }

    //find min in the decrease seq that larger then num[k]
    /*
    int minInDescLargerThanK = nums.length - 1;
    while (nums[minInDescLargerThanK] < nums[decreaseStart]) {
      minInDescLargerThanK--;
    }*/

    int minInDescLargerThanK = decreaseStart + 1;
    for(int i = nums.length - 1; i >= 0; i--) {
      if(nums[i] > nums[decreaseStart]) {
        minInDescLargerThanK = i;
        break;
      }
    }

    swap(nums, decreaseStart, minInDescLargerThanK);
    reverse(nums, decreaseStart+1, nums.length-1);
  }

  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  private void reverse(int[] nums, int left, int right) {
    while (left < right) {
      swap(nums, left, right);
      left++;
      right--;
    }
  }
}
