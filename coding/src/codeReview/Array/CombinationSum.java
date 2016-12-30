package codeReview.Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangdong on 11/9/16.
 *
 * All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if(candidates == null || target == 0) {
      return new ArrayList<>();
    }

    //find from small to big, cut branch
    Arrays.sort(candidates);

    return helper(candidates, 0, target);
  }

  private List<List<Integer>> helper(int[] candidates, int startIdx, int target) {
    List<List<Integer>> res = new ArrayList<>();

    for(int i = startIdx; i < candidates.length; i++) {
      //skip repeat number
      if(i-1 >= 0  && candidates[i-1] == candidates[i]) {
        continue;
      }

      if(candidates[i] < target) {
        int currentNum = candidates[i];
        //choose current number, find from i (can contain current number twice)
        //find remain by have i or i+1 or i+2 ...in next iteration
        List<List<Integer>> nextResult = helper(candidates, i, target - candidates[i]);

        for(List<Integer> r : nextResult) {
          r.add(0, currentNum);
        }
        res.addAll(nextResult);
      } else if(candidates[i] == target) {
        List<Integer> path = new ArrayList<>();
        path.add(candidates[i]);
        res.add(path);
      } else {
        break;
      }
    }

    return res;
  }
}
