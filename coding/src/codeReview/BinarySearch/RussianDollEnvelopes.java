package codeReview.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangdong on 6/30/16.
 */
public class RussianDollEnvelopes{

  class Envelope implements Comparable<Envelope>{
    public int height;
    public int width;
    public Envelope(int height, int width) {
      this.height = height;
      this.width = width;
    }

    public int compareTo(Envelope that) {
      if(this.height > that.height) {
        return 1;
      } else if (this.height == that.height) {
        //reverse the second attribute order (remove errors in LSI on second attributes)
        return this.width < that.width ? 1 : (this.width == that.width ? 0 : -1);
      } else {
        return -1;
      }
    }
  }

  private int binarySearch(int[] smallestElemOfEachLength, int startIdx, int endIdx, int key) {
    if(key > smallestElemOfEachLength[endIdx]) {
      return endIdx + 1;
    }

    int start = startIdx;
    int end = endIdx;
    //find idx >= key
    while(start <= end) {
      int mid = start + (end - start)/2;
      if(smallestElemOfEachLength[mid] < key) {
        start = mid + 1;
      } else {
        //Key <= a[mid] move
        end = mid - 1;
      }
    }

    return start;
  }

  public int maxEnvelopes(int[][] envelopes) {
    if(envelopes == null || envelopes.length == 0) {
      return 0;
    }
    List<Envelope> envelopeInfos = new ArrayList<>();
    for(int[] envelop : envelopes) {
      envelopeInfos.add(new Envelope(envelop[0], envelop[1]));
    }

    List<Envelope> sortedEnvelops = envelopeInfos.stream()
            .sorted().collect(Collectors.toList());

    //find the LSI for second attributes
    int[] widthVals = new int[sortedEnvelops.size()];
    int index = 0;
    for(Envelope envelope : sortedEnvelops){
      widthVals[index++] = envelope.width;
    }

    int[] smallestElemOfEachLength = new int[widthVals.length + 1];
    smallestElemOfEachLength[1] = widthVals[0];
    int maxLength = 1;

    for(int i = 1; i < widthVals.length; i++) {
      int idx = binarySearch(smallestElemOfEachLength, 1, maxLength, widthVals[i]);
      smallestElemOfEachLength[idx] = widthVals[i];
      if(idx > maxLength) {
        maxLength = idx;
      }
    }

    return maxLength;
  }
}
