package com.ms;

import codeReview.Utilities.ListNode;

/**
 * Created by wangdong on 11/20/16.
 */
public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode mergedHead = new ListNode(0);
    ListNode cur = mergedHead;

    while (l1 != null && l2 != null) {
      if(l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }

    while (l1 != null) {
      cur.next = l1;
      l1 = l1.next;
      cur = cur.next;
    }

    while (l2 != null) {
      cur.next = l2;
      l2 = l2.next;
      cur = cur.next;
    }

    return mergedHead.next;
  }
}
