package BasicaAlgorithm;

/**
 * Created by wangdong on 10/31/16.
 *
 * http://quiz.geeksforgeeks.org/quick-sort/
 */
public class QuickSort {
  public void quickSort(int[] nums) {
    if(nums == null || nums.length == 0) {
      return;
    }

    helper(nums, 0, nums.length - 1);
  }

  private void helper(int[] nums, int startIdx, int endIdx) {
    if(startIdx < endIdx) {
      //do sort
      int partitionIdx = partition(nums, startIdx, endIdx);
      helper(nums, startIdx, partitionIdx-1);
      helper(nums, partitionIdx+1, endIdx);
    }
  }

  private int partition(int[] nums, int start, int end) {
    int pivot = nums[end];
    int left = start - 1;

    for(int i = start; i < end; i++) {
      if(nums[i] <= pivot) {
        left++;
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
      }
    }

    left++;
    nums[end] = nums[left];
    nums[left] = pivot;
    return left;
  }
}
