package com.ms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wangdong on 11/22/16.
 */
public class KthLargestElementInAnArray {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> kLarge = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;
      }
    });

    for(int num : nums) {
      if(kLarge.size() == k) {
        //compare with top, if large then the samller one, insert, remove top and insert
        if(kLarge.peek() < num) {
          kLarge.poll();
          kLarge.add(num);
        }
      } else {
        //if not reach K, continue insert
        kLarge.add(num);
      }
    }


    /*
      kth largest
      .
      .
      2 largest
      1 largest
     */
    return kLarge.poll();
  }
}
