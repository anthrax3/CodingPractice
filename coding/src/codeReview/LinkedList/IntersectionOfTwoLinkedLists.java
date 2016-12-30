package codeReview.LinkedList;

import codeReview.Utilities.ListNode;

import java.util.HashSet;

/**
 * Created by wangdong on 10/10/16.
 */
public class IntersectionOfTwoLinkedLists {
  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    HashSet<ListNode> dic = new HashSet<>();
    while (headA != null) {
      dic.add(headA);
      headA = headA.next;
    }

    while (headB != null) {
      if(dic.contains(headB)) {
        return headB;
      }
      headB = headB.next;
    }

    return null;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null) {
      return null;
    }
    ListNode headAStart = headA;
    ListNode headBStart = headB;

    while (headA != null || headB != null) {
      //A + B = B + A 总长度相同
      //把null 变成另一个开头,最终都移动了相同距离, 在交叉点相遇
      if(headA == null) {
        //move to B head
        headA = headBStart;
      }
      if(headB == null) {
        headB = headAStart;
      }
      if(headA == headB) {
        return headA;
      }
      headA = headA.next;
      headB = headB.next;
    }

    return null;
  }


}
