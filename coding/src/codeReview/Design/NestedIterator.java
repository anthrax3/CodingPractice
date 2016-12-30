package codeReview.Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangdong on 8/17/16.
 */
public class NestedIterator implements Iterator<Integer> {
  List<Integer> flattenList;
  Iterator<Integer> integerIterator;

  private List<Integer> flatten(List<NestedInteger> nestedList) {
    List<Integer> flattenList = new ArrayList<>();

    for(NestedInteger nestedInteger : nestedList) {
      if(nestedInteger.isInteger()) {
        flattenList.add(nestedInteger.getInteger());
      } else {
        flattenList.addAll(flatten(nestedInteger.getList()));
      }
    }

    return flattenList;
  }
  public NestedIterator(List<NestedInteger> nestedList) {
    flattenList = flatten(nestedList);
    integerIterator = flattenList.iterator();
  }

  @Override
  public Integer next() {
    return integerIterator.next();
  }

  @Override
  public boolean hasNext() {
    return integerIterator.hasNext();
  }

  public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }
}
