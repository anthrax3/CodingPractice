package com.ms;

import codeReview.Utilities.ListNode;

/**
 * Created by wangdong on 11/20/16.
 */
public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    if(head == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        return true;
      }
    }

    return false;
  }
}
