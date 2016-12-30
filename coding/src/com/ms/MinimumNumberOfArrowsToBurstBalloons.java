package com.ms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wangdong on 11/13/16.
 */
public class MinimumNumberOfArrowsToBurstBalloons {
  public int findMinArrowShots(int[][] points) {
    if(points == null || points.length == 0) {
      return 0;
    }

    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
      }
    });

    int[] currentRange = points[0];
    int count = 1;

    for(int i = 1; i < points.length; i++) {
      //has over lap
      if(points[i][0] <= currentRange[1]) {
        //update range
        currentRange[0] = points[i][0];
        currentRange[1] = Math.min(currentRange[1], points[i][1]);
      } else {
        count++;
        currentRange = points[i];
      }
    }

    return count;
  }
}
