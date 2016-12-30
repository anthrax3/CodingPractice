package codeReview.Utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdong on 10/8/16.
 */

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;
    // Constructor initializes an empty nested list.
    public  NestedInteger() {
      list = new ArrayList<>();
    };

    // Constructor initializes a single integer.
    public NestedInteger(int value){
      list = new ArrayList<>();
      NestedInteger nestedInteger = new NestedInteger();
      nestedInteger.setInteger(value);
      list.add(nestedInteger);
    };

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
      if(list.size() == 1 && list.get(0).isInteger()) {
        return true;
      } else {
        return false;
      }
    };

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
      if(this.isInteger()) {
        return value;
      } else {
        return null;
      }
    };

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
      this.value = value;
    };

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
      list = new ArrayList<>();
      list.add(ni);
    };

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
      if(list != null) {
        return list;
      } else {
        return null;
      }
    };
}

