package com.ms;

import codeReview.Utilities.ListNode;

/**
 * Created by wangdong on 11/19/16.
 *
 * Write a function to delete a node (TODO except the tail)
 * in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 the linked list should become 1 -> 2 -> 4
 */
public class DeleteNodeInALinkedList {
  //copy value
  //how to delete the last node
  public void deleteNode(ListNode node) {
    while (node != null) {
      ListNode next = node.next;
      if(next != null) {
        node.val = next.val;
        //if this is the end
        if(next.next == null) {
          node.next = null;
          return;
        }
      }
      node = next;
    }
  }
}
