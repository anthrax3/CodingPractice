package codeReview.BinarySearch;

/**
 * Created by wangdong on 6/15/16.
 */
public class HIndexTwo {
  public int hIndex(int[] citations) {
    if(citations == null || citations.length == 0) {
      return 0;
    }

    int start = 0;
    int end = citations.length - 1;
    while(start <= end) {
      int mid = start + (end - start)/2;
      int citation = citations[mid];
      int paperCount = citations.length - mid;

      if(paperCount > citation) {
        //try higher H index
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    //when start == end, that record is not match condition
    //then finally we moved end to the left of start
    //[1,2,2,6,7,8]  citation
    // 6,5,4,3,2,1  paper
    //     E S
    return citations.length - start;
  }
}
