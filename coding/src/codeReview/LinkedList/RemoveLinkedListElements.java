package codeReview.LinkedList;

import codeReview.Utilities.ListNode;

/**
 * Created by wangdong on 10/10/16.
 */
public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    if(head == null) {
      return null;
    }
    ListNode newHead = new ListNode(0);
    ListNode cur = newHead;

    while (head != null) {
      if(head.val != val) {
        //append a new node
        cur.next = head;
        //move cur
        cur = cur.next;
      }
      head = head.next;
    }
    cur.next = null;
    return newHead.next;
  }
}
