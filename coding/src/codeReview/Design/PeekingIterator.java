package codeReview.Design;

import java.util.Iterator;

/**
 * Created by wangdong on 8/17/16.
 */
class PeekingIterator implements Iterator<Integer> {
  private Iterator<Integer> iterator;
  private Integer next;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    if(iterator.hasNext()) {
      next = iterator.next();
    }
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return next;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    Integer currentNext = next;
    if(iterator.hasNext()) {
      next = iterator.next();
    } else {
      next = null;
    }

    return currentNext;
  }

  @Override
  public boolean hasNext() {
    if(next != null) {
      return true;
    } else {
      return false;
    }
  }
}
