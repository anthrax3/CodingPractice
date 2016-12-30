package codeReview.Array;

/**
 * Created by wangdong on 11/11/16.
 *
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.

 * 其实交换的条件就是3个：

 1: A[i] is in the range;
 2: A[i] > 0.
 3: The target is different; （如果不判断这个，会造成死循环，因为你交换过来一个一样的值）
 */
public class FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    if(nums.length == 0) {
      return 1;
    }

    // 0 , 1, 2, 3 => range 4
    //number num[i] should in num[i]-1 index, current index is i
    int range = nums.length;
    for(int i = 0; i < range; i++) {
      while (nums[i] > 0 && nums[i]-1 != i && nums[i] <= range) {
        int targetIdx = nums[i] - 1;
        int targetVal = nums[targetIdx];
        if(targetVal != nums[i]) {
          nums[targetIdx] = nums[i];
          nums[i] = targetVal;
        } else {
          break;
        }
      }
    }

    for(int i = 0; i < range; i++) {
      //if(nums[i] > 0 && nums[i] - 1 != i) {
      if(nums[i] - 1 != i) {
        return i+1;
      }
    }

    return range + 1;
  }
}
