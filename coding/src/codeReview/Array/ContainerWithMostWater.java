package codeReview.Array;

/**
 * Created by wangdong on 11/7/16.
 *
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 */
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    if(height == null || height.length == 0) {
      return 0;
    }
    int left = 0;
    int right = height.length - 1;
    int maxWater = 0;

    while (left < right) {
      int water = (right - left) * Math.min(height[left], height[right]);
      maxWater = Math.max(water, maxWater);
      if(height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return maxWater;
  }
}
