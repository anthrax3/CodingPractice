package codeReview.Design;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wangdong on 8/17/16.
 */
public class MedianFinder {
  PriorityQueue<Integer> largestValOnLeftSide = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return o2.compareTo(o1);
    }
  });

  PriorityQueue<Integer> smallestValOnRightSide = new PriorityQueue<>();

  // Adds a number into the data structure.
  public void addNum(int num) {
    if (largestValOnLeftSide.isEmpty() || largestValOnLeftSide.peek() >= num) {
      largestValOnLeftSide.add(num);
    }
    else {
      smallestValOnRightSide.add(num);
    }

    if(largestValOnLeftSide.size() - smallestValOnRightSide.size() > 1) {
      smallestValOnRightSide.add(largestValOnLeftSide.poll());
    }
    else if(smallestValOnRightSide.size() - largestValOnLeftSide.size() > 1) {
      largestValOnLeftSide.add(smallestValOnRightSide.poll());
    }
  }

  // Returns the median of current data stream
  public double findMedian() {
    if(largestValOnLeftSide.size() == smallestValOnRightSide.size()) {
      return (largestValOnLeftSide.peek() + smallestValOnRightSide.peek())/2.0;
    }
    else if(largestValOnLeftSide.size() > smallestValOnRightSide.size()) {
      return (double)largestValOnLeftSide.peek();
    } else {
      return (double)smallestValOnRightSide.peek();
    }
  }
}
