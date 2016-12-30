package Basic;

import BasicaAlgorithm.QuickSort;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wangdong on 11/1/16.
 */
public class Sort {
  @Test
  public void QuickSort() {
    QuickSort sort = new QuickSort();
    int[] a = new int[] {7,3,5,9,10, 8, 22,5,7,1};
    sort.quickSort(a);
    System.out.println(Arrays.toString(a));
  }
}
