package codeReview.HashTable;

import codeReview.Utilities.Point;

import java.util.HashMap;

/**
 * Created by wangdong on 10/10/16.
 */
public class MaxPointsOnALine {
  //y = ax + b
  //find each root point P(x, y) for all other points, calculate K
  //O(N^2)
  public int maxPoints(Point[] points) {
    if(points == null || points.length == 0) {
      return 0;
    }


    int ans = 0;
    for(int i = 0; i < points.length; i++) {
      int sameCordinates = 0;
      int infinityK = 0;
      HashMap<Double, Integer> kQuantity = new HashMap<>();

      Point p = points[i];

      for(int j = i+1; j < points.length; j++) {
        Point cur = points[j];
        if(p.x == cur.x) {
          if(p.y == cur.y) {
            sameCordinates++;
          } else {
            //vertically on same line, k is infinity
            infinityK++;
          }
        } else {
          double k = (double)(cur.y - p.y)/(cur.x - p.x);
          kQuantity.putIfAbsent(k, 0);
          kQuantity.put(k, kQuantity.get(k) + 1);
        }
      }

      int maxQuantityK = kQuantity.values().stream().max(Integer::max).orElse(0);
      int currentMax = Math.max(maxQuantityK, infinityK) + sameCordinates;
      ans = Math.max(ans, currentMax);
    }

    return ans;
  }

}
