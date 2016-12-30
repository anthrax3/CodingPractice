package leetcode;

import codeReview.Array.MedianOfTwoSortedArrays;
import org.junit.Test;

/**
 * Created by wangdong on 10/30/16.
 */
public class MedianTest {
  @Test
  public void testFindMedianInTwoSortedArray() {
    MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
    median.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
  }
}
