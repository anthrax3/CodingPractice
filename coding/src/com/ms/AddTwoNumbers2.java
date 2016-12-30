package com.ms;

import codeReview.Utilities.ListNode;

/**
 * Created by wangdong on 11/13/16.
 */
public class AddTwoNumbers2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null) {
      return l2;
    }
    if(l2 == null) {
      return l1;
    }
    ListNode reversedHead1 = reverse(l1);
    ListNode reversedHead2 = reverse(l2);

    ListNode dummyHead = new ListNode(-1);
    ListNode cur = dummyHead;
    int high = 0;

    while (reversedHead1 != null && reversedHead2 != null) {
      int val = (high + reversedHead1.val + reversedHead2.val)%10;
      high = (high + reversedHead1.val + reversedHead2.val)/10;

      ListNode next = new ListNode(val);
      cur.next = next;
      cur = next;
      reversedHead1 = reversedHead1.next;
      reversedHead2 = reversedHead2.next;
    }

    ListNode remain;
    if(reversedHead1 == null) {
       remain = reversedHead2;
    } else {
      remain = reversedHead1;
    }

    while (remain != null) {
      int val = (remain.val + high)%10;
      high = (remain.val + high)/10;
      cur.next = new ListNode(val);
      remain = remain.next;
    }
    if(high != 0) {
      cur.next = new ListNode(high);
    }

    return reverse(dummyHead.next);
  }
  private ListNode reverse(ListNode start) {
    ListNode head = start;
    ListNode cur = head;
    ListNode next = head.next;

    while (next != null) {
      ListNode temp = next.next;
      next.next = cur;
      cur = next;
      next = temp;
    }

    start.next = null;
    return cur;
  }

  private int getLength(ListNode node) {
    int length = 0;
    while (node != null) {
      length++;
      node = node.next;
    }

    return length;
  }
}
