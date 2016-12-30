package codeReview.Design;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wangdong on 12/13/16.
 */
public class Vector2D implements Iterator<Integer> {
  List<List<Integer>> data;
  Iterator<List<Integer>> rowIterator;
  Iterator<Integer> columIterator;

  public Vector2D(List<List<Integer>> vec2d) {
    data = vec2d;
    rowIterator = data.iterator();
  }

  @Override
  public Integer next() {
    if(this.hasNext()) {
      return columIterator.next();
    } else {
      return null;
    }
  }

  @Override
  public boolean hasNext() {
    //if column iterator is null or empty, find next available iterator
    while( (columIterator == null || !columIterator.hasNext()) && rowIterator.hasNext()) {
      columIterator = rowIterator.next().iterator();
    }

    return (columIterator != null && columIterator.hasNext());
  }
}
