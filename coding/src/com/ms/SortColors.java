package com.ms;

/**
 * Created by wangdong on 11/16/16.
 *
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red,
 white, and blue respectively.
 */
public class SortColors {
  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
  public void sortColors(int[] nums) {
    if(nums == null || nums.length == 0) {
      return;
    }
    int a = 0;
    int c = nums.length-1;
    int idx = 0;

    while (idx < c){
      if(nums[idx] == 0) {
        swap(nums, a, idx);
        a++;
        //TODO move index at the same time
        idx++;
      } else if(nums[idx] == 1) {
        idx++;
      } else {
        swap(nums, c, idx);
        c--;
      }
    }
  }
}
