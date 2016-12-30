package codeReview.Array;

import codeReview.Utilities.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangdong on 11/13/16.
 */
public class MergeIntervals {
  public List<Interval> merge(List<Interval> intervals) {
    if(intervals == null || intervals.size() < 2) {
      return intervals;
    }

    Collections.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });

    Iterator<Interval> iterator = intervals.iterator();
    Interval last = intervals.get(0);
    List<Interval> res = new ArrayList<>();

    while (iterator.hasNext()) {
      Interval cur = iterator.next();
      if(cur.start > last.end) {
        res.add(last);
        last = cur;
      } else {
        last = new Interval(last.start, Math.max(last.end, cur.end));
      }
    }

    res.add(last);
    return res;
  }
}
