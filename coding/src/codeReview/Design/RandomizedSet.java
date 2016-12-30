package codeReview.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by wangdong on 10/29/16.
 */
public class RandomizedSet {
  private class Node {
    Node pre;
    Node next;
    int val;

    public Node() {}

    public Node(int val) {
      this.val = val;
    }
  }

  Node head;
  Node tail;
  HashMap<Integer, Node> valNodeRef;
  /** Initialize your data structure here. */
  public RandomizedSet() {
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.pre = head;
    valNodeRef = new HashMap<>();
  }

  private void insertAfterHead(Node element) {
    Node second = head.next;
    head.next = element;
    element.pre = head;

    element.next = second;
    second.pre = element;
  }

  private void removeNode (Node element) {
    element.pre.next = element.next;
    element.next.pre = element.pre;
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if(valNodeRef.containsKey(val)) {
      return false;
    }
    Node element = new Node(val);
    insertAfterHead(element);
    valNodeRef.put(val, element);

    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if(!valNodeRef.containsKey(val)) {
      return false;
    }

    Node element = valNodeRef.get(val);
    valNodeRef.remove(val);
    removeNode(element);

    return true;

  }

  /** Get a random element from the set. */
  public int getRandom() {
    Random rand = new Random();
    ArrayList<Integer> values = new ArrayList<>(valNodeRef.keySet());

    int idx =  rand.nextInt(valNodeRef.size()) + 1;
    return values.get(idx);
  }
}
