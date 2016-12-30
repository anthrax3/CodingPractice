package com.ms;

import codeReview.Utilities.ListNode;

/**
 * Created by wangdong on 11/27/16.
 */
public class ReverseNodesInkGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || k <= 1) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;

    while(pre.next != null) {
      pre = reverseK(pre, k);
    }

    return dummy.next;
  }

  private ListNode reverseK(ListNode pre, int k) {
    //first check whether have k nodes
    ListNode check = pre;
    for(int i = 0; i < k; i++) {
      if(check.next == null) {
        return check;
      }
      check = check.next;
    }

    ListNode cur = pre.next;
    ListNode postCur = cur.next;

    System.out.println(pre.val);
    //K nodes, need relink k-1 time A->B->C, use 2 times relink
    for(int i = 0; i < k - 1; i++) {
      ListNode temp = postCur.next;

      postCur.next = cur;

      cur = postCur;
      postCur = temp;
    }

    ListNode reverseEnd = pre.next;
    pre.next.next = postCur;
    pre.next = cur;

    return reverseEnd;
  }
}
