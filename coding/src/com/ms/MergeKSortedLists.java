package com.ms;

import codeReview.Utilities.ListNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wangdong on 11/27/16.
 */
public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> kLarge = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });
    for(ListNode head : lists) {
      //TODO do new check before insert
      if(head != null) {
        kLarge.add(head);
      }
    }

    ListNode res = new ListNode(0);
    ListNode cur = res;

    while(!kLarge.isEmpty()) {
      ListNode top = kLarge.poll();
      cur.next = top;
      cur = cur.next;
      //TODO do new check before insert
      if(top.next != null) {
        kLarge.add(top.next);
      }
    }

    return res.next;
  }
}
