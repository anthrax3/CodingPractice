package codeReview.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by wangdong on 8/22/16.
 */
public class RandomizedSetOld {
  /** Initialize your data structure here. */
  HashMap<Integer, Integer> valueIdx;
  ArrayList<Integer> values;

  public RandomizedSetOld() {
    valueIdx = new HashMap<>();
    values = new ArrayList<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(valueIdx.containsKey(val)) {
      return false;
    }
    values.add(val);
    valueIdx.put(val, values.size() - 1);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(!valueIdx.containsKey(val)){
      return false;
    }

    int lastVal = values.get(values.size()-1);
    int removeIdx = valueIdx.get(val);

    if(removeIdx != values.size() - 1) {
      //exchange last value to remove idx
      values.set(removeIdx, lastVal);
      valueIdx.put(lastVal, removeIdx);
    }

    //remove last int from values, remove val from values
    values.remove(values.size()-1);
    valueIdx.remove(val);

    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    Random random = new Random(values.size());
    return values.get(random.nextInt());
  }
}
