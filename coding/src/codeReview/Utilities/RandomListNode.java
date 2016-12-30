package codeReview.Utilities;

/**
 * Created by wangdong on 11/15/16.
 *
 * Definition for singly-linked list with a random pointer.
 */
public class RandomListNode {
    public int label;
    public RandomListNode next, random;
    public RandomListNode(int x) { this.label = x; }
}