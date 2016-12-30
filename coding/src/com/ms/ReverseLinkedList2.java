package com.ms;

import codeReview.Utilities.ListNode;

/**
 * Created by wangdong on 11/27/16.
 */
public class ReverseLinkedList2 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null || m >= n) {
      return head;
    }

    //add dummy node incase reverse first one
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;

    //find m-1 node
    for(int i = 0; i < m-1; i++) {
      head = head.next;
    }

    ListNode pre = head.next;
    ListNode cur = pre.next;

    //reverse from m to n
    //TODO m to n, do reverse n-m-1 time
    for(int i = m; i < n; i++) {
      ListNode nextTemp = cur.next;
      cur.next = pre;

      //update
      pre = cur;
      cur = nextTemp;
    }

    //finally, pre is the n node, cur is n+1 node
    //head.next is the m node
    head.next.next = cur;
    head.next = pre;

    return dummy.next;
  }
}
