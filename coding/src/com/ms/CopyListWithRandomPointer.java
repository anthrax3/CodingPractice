package com.ms;

import codeReview.Utilities.RandomListNode;

import java.util.HashMap;

/**
 * Created by wangdong on 11/15/16.
 */
public class CopyListWithRandomPointer {
  public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) {
      return null;
    }

    HashMap<RandomListNode, RandomListNode> oldToNew = new HashMap<>();
    RandomListNode dummyNewHead = new RandomListNode(-1);
    RandomListNode newHead = dummyNewHead;

    while (head != null) {

      RandomListNode copy;
      if(!oldToNew.containsKey(head)) {
        //new node, need copy
        copy = new RandomListNode(head.label);
        oldToNew.put(head, copy);
      } else {
        //already create before, just get and insert link
        copy = oldToNew.get(head);
      }

      dummyNewHead.next = copy;

      //process random
      RandomListNode oldRandom = head.random;
      if(oldRandom != null) {
        if(oldToNew.containsKey(oldRandom)) {
          copy.random = oldToNew.get(oldRandom);
        } else {
          RandomListNode copyRandom = new RandomListNode(oldRandom.label);
          oldToNew.put(oldRandom, copyRandom);
          copy.random = copyRandom;
        }
      }

      head = head.next;
      dummyNewHead = dummyNewHead.next;
    }

    return newHead.next;
  }


  //TODO fix bug
  //http://www.jiuzhang.com/solutions/copy-list-with-random-pointer/
  public RandomListNode copyRandomList2(RandomListNode head) {
    //1. copy after current A->A'->B->B'
    if(head == null) {
      return null;
    }

    RandomListNode oldHead = head;
    while (oldHead != null) {
      RandomListNode copy = new RandomListNode(oldHead.label);
      //insert after current
      copy.next = oldHead.next;
      oldHead.next = copy;
      //move to next
      oldHead = copy.next;
    }

    RandomListNode traver = head;
    RandomListNode dummpyHeadForCopy = new RandomListNode(0);
    RandomListNode copyStart = dummpyHeadForCopy;

    while (traver != null) {
      RandomListNode copy = traver.next;

      RandomListNode oldRandom = traver.random;
      if(oldRandom != null) {
        //copy relation
        copy.random = oldRandom.next;
      }

      //revover
      RandomListNode next = traver.next.next;
      traver.next = next;
      traver = traver.next;

      copyStart.next = copy;
      copyStart = copy;
    }

    return dummpyHeadForCopy.next;
  }
}
