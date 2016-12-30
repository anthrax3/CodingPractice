package codeReview.Array;

/**
 * Created by wangdong on 11/11/16.
 *
 * 对每个矩形底,找出左右边的最高值
 *
 * 对每个底, 水为 min(left, right) - cur if min(left, right) > cur
 */
public class TrappingRainWater {
  public int trap(int[] height) {
    if(height.length == 0) {
      return 0;
    }

    int[] leftBoundaryHeight = new int[height.length];
    int[] rightBoundaryHeight = new int[height.length];

    for(int i = 0; i < height.length; i++) {
      leftBoundaryHeight[i] = i == 0 ? height[i] : Math.max(leftBoundaryHeight[i-1], height[i]);
    }

    for(int i = height.length-1; i >= 0; i--) {
      rightBoundaryHeight[i] = i == height.length-1 ? height[i] : Math.max(height[i], rightBoundaryHeight[i+1]);
    }

    int total = 0;
    for(int i = 0; i < height.length; i++) {
      total += (Math.min(leftBoundaryHeight[i], rightBoundaryHeight[i]) - height[i]);
    }

    return total;
  }
}
