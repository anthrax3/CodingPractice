package codeReview.graph;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by wangdong on 10/27/16.
 */
public class PacificAtlanticWaterFlow {
  /*
  public List<int[]> pacificAtlantic(int[][] matrix) {
    if(matrix == null || matrix[0] == null) {
      return new ArrayList<>();
    }

    Set<Pair<Integer, Integer>> pacific = new HashSet<>();
    Set<Pair<Integer, Integer>> atlantic = new HashSet<>();

    for(int row = 0; row < matrix.length; row++) {
      pacific.add(Pair.of(row, 0));
      atlantic.add(Pair.of(row, matrix[0].length-1));
    }
    for(int column = 0; column < matrix[0].length; column++) {
      pacific.add(Pair.of(0, column));
      atlantic.add(Pair.of(matrix.length-1, column));
    }
  }

  private void bsf(int[][] matrix, Set<Pair<Integer, Integer>> nodes) {
    Queue<Pair<Integer, Integer>> nodesToVisit = new LinkedList<>();
    nodesToVisit.addAll(nodes);

    while (!nodesToVisit.isEmpty()) {
      Pair<Integer, Integer> next = nodesToVisit.poll();

    }
  }*/
}
