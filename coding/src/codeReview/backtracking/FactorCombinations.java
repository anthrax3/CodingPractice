package codeReview.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 12/6/16.
 */
public class FactorCombinations {
  public List<List<Integer>> getFactors(int n) {
    if(n <= 1) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();

    helper(n, 2, res, new ArrayList());

    return res;
  }

  public void helper(int n, int startFactor, List<List<Integer>> res, List<Integer> cur) {
    if(n == 1) {
      if(cur.size() > 1) {
        res.add(new ArrayList<>(cur));
      }
      return;
    } else {
      for(int i = startFactor; i <= n; i++) {
        if(n%i == 0) {
          //valid factor
          cur.add(i);
          helper(n/i, i, res, cur);
          cur.remove(cur.size()-1);
        }
      }
    }
  }


  //method 2
  public List<List<Integer>> getFactors2(int n) {
    List<List<Integer>> res = new ArrayList();

    for(int i = 2; i*i <= n; i++) {
      if(n%i == 0) {
        ArrayList<Integer> currentRest = new ArrayList();
        currentRest.add(i);
        currentRest.add(n/i);

        res.add(currentRest);
        //factor from small to big
        List<List<Integer>> subRest = getFactors2(n/i);

        for(List<Integer> sub : subRest) {
          //exclude duplicate. Keep 2*3, skip 3*2
          if(i <= sub.get(0)) {
            sub.add(0, i);
            res.add(sub);
          }
        }
      }
    }

    return res;
  }
}
