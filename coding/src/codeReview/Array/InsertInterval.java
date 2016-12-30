package codeReview.Array;

import codeReview.Utilities.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by wangdong on 11/13/16.
 */
public class InsertInterval {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (intervals == null || intervals.isEmpty()) {
      return Arrays.asList(newInterval);
    }


    Iterator<Interval> iterator = intervals.iterator();
    List<Interval> res = new ArrayList<>();
    boolean mergeInsert = false;

    while (iterator.hasNext()) {
      Interval cur = iterator.next();
      if(cur.end < newInterval.start) {
        //current is before, direct insert, do not need to update merged one
        res.add(cur);
      } else if( (newInterval.start <= cur.end && newInterval.end >= cur.start)||
              (newInterval.end >= cur.start && newInterval.start <= cur.end)) {
        newInterval = new Interval(Math.min(cur.start, newInterval.start), Math.max(cur.end, newInterval.end));
      } else {
        //cur after the new interval
        if(!mergeInsert) {
          res.add(newInterval);
          mergeInsert = true;
        }

        res.add(cur);
      }
    }

    if(!mergeInsert) {
      res.add(newInterval);
    }

    return res;
  }
}
