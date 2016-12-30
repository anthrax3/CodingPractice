package codeReview.BinarySearch;

/**
 * Created by wangdong on 10/17/16.
 */
public class TwoPointers2 {
  public int[] twoSum(int[] numbers, int target) {
    int start = 0;
    int end = numbers.length - 1;
    int[] res = new int[2];

    while (start < end) {
      if(numbers[start] + numbers[end] > target) {
        end--;
      } else if (numbers[start] + numbers[end] < target) {
        start++;
      } else {
        res[0] = start;
        res[1] = end;
        return res;
      }
    }

    return res;
  }
}
