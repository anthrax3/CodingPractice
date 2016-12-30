package codeReview.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wangdong on 6/14/16.
 */
public class Hindex {

  public int hIndex1(int[] citations) {
    if(citations == null || citations.length == 0) {
      return 0;
    }


    List<Integer> sortedCitations = IntStream.of(citations)
            .boxed().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());


    int hIndex = 0;
    for(int i = 0; i < sortedCitations.size(); i++) {
      hIndex = Math.max(hIndex, Math.min(i + 1, sortedCitations.get(i)));
    }

    return hIndex;
  }

  public int hIndex(int[] citations) {
    if(citations == null || citations.length == 0) {
      return 0;
    }

    //summarize how many papers has same citation
    int[] citationCount = new int[citations.length + 1];
    for(int citation : citations) {
      if (citation > citations.length) {
        //as we have citation length paper, the max high index is length so keep them in one place
        citationCount[citations.length] += 1;
      } else {
        citationCount[citation] += 1;
      }
    }

    //loop from high citation to low, compare citation and paper number
    int paperNum = 0;
    for(int i = citationCount.length-1; i >= 0; i--) {
      paperNum += citationCount[i];
      //Have x paper with x or more citation, output the highest one
      if(paperNum >= i) {
        return i;
      }
    }
    return 0;
  }
}
