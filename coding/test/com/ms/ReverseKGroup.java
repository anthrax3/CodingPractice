package com.ms;

import codeReview.Utilities.ListNode;
import org.junit.Test;

/**
 * Created by wangdong on 12/3/16.
 */
public class ReverseKGroup {
  @Test
  public void testReverseK() {
    ReverseNodesInkGroup reverseNodesInkGroup = new ReverseNodesInkGroup();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    reverseNodesInkGroup.reverseKGroup(head, 2);
  }
}
