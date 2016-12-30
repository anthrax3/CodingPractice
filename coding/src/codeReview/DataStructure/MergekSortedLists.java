package codeReview.DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wangdong on 5/16/16.
 */
public class MergekSortedLists {
    /* this one can use divide and conquer, but may timeout
     * O(K) for smallest number, total N numbers O(N * K)
     * another way is using min heap
     * O(K) to build heap, O(1) to get the head, O(logK) to rebuild the min heap
     * O(K) + K O(1) + N (logK) = O (K + N logK)
     */

    //For divide and conquer
    //1. get to list to merge
    //2. For merge of two, recurrsivelly call merge two on each pair of nodes

    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }

        //Initialize capacity to K, may not used all of K as have null value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                //Compare two list node, priority queue from low to high
                return o1.val - o2.val;
            }
        });

        ListNode sortedListHead  = new ListNode(0);
        ListNode current = sortedListHead;
        for(ListNode start : lists) {
            if(start != null) {
                minHeap.add(start);
            }
        }

        while (!minHeap.isEmpty()){
            ListNode min = minHeap.poll();
            if(min.next != null) {
                minHeap.add(min.next);
            }
            current.next = min;
            current = current.next;
        }
        //Don't forget to add stop element
        current.next = null;

        return sortedListHead.next;
    }
}
