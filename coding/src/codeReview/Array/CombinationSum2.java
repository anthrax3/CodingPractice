package codeReview.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdong on 11/10/16.
 */
public class CombinationSum2 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if(candidates == null || candidates.length == 0) {
      return new ArrayList<>();
    }

    Arrays.sort(candidates);
    ArrayList<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    helper(candidates, 0, target, path, res);

    return res;
  }

  private void helper(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> res) {
    for(int i = start; i < candidates.length; i++) {
      //1, 1, 1, 7 find 2
      // only first 1 will use second and third 1
      //TODO i-1 in current range !!! instead i-1 >=0
      if(i-1 >= start && candidates[i] == candidates[i-1]) {
        continue;
      }

      if(candidates[i] < target) {
        path.add(candidates[i]);
        helper(candidates, i+1, target-candidates[i], path, res);
        //remove from end
        path.remove(path.size() - 1);
      } else if(candidates[i] == target) {
        //copy list and insert
        ArrayList<Integer> validPath = new ArrayList<>(path);
        validPath.add(candidates[i]);
        res.add(validPath);
      } else {
        break;
      }
    }
  }
}
