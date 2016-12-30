package codeReview.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wangdong on 7/18/16.
 */
public class CombinationSum3 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> currentPath = new ArrayList<>();
    helper(1, n, k, currentPath, res);
    return res;
  }

  private void helper(int startNum, int remainSum, int remainCount, List<Integer> currentPath, List<List<Integer>> res) {
    if(remainSum < 0 || remainCount < 0) {
      return;
    }
    if(remainSum != 0 && (remainCount == 0 || startNum >= 10) ) {
      return;
    }
    if(remainSum == 0 && remainCount == 0) {
      res.add(currentPath);
      return;
    }

    //new search without current num
    List<Integer> pathWithoutCurrent = new ArrayList<Integer>(currentPath);
    helper(startNum+1, remainSum, remainCount, pathWithoutCurrent, res);
    //new search with current num
    List<Integer> pathWithCurrent = new ArrayList<Integer>(currentPath);
    pathWithCurrent.add(startNum);
    helper(startNum+1, remainSum - startNum, remainCount - 1, pathWithCurrent, res);
  }
}
