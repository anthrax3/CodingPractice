package codeReview.Design;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Created by wangdong on 12/3/16.
 */
public class LFUCache {
  HashMap<Integer, Integer> keyValue;
  HashMap<Integer, Node> keyCountNode;
  int capacity;
  Node head = null;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    keyValue = new HashMap<Integer, Integer>();
    keyCountNode = new HashMap<Integer, Node>();
  }

  public int get(int key) {
    if(keyValue.containsKey(key)) {
      //update count
      increaseCount(key);
      return keyValue.get(key);
    }
    return -1;
  }

  public void set(int key, int value) {
    //TODO do the check
    if(capacity == 0) {
      return;
    }
    System.out.println("key value: " + key + "," + value);
    if(keyValue.containsKey(key)) {
      System.out.println("contain");
      keyValue.put(key, value);
    } else {
      //insert a new key
      if(keyValue.size() < capacity) {
        System.out.println("<");
        //directly add
        keyValue.put(key, value);
      } else {
        //remove the old key first
        System.out.println("remove");
        removeOld();
        keyValue.put(key, value);
      }
      insertAtHead(key);
    }

    increaseCount(key);
  }

  private void insertAtHead(int key) {
    if(head == null) {
      head = new Node(0);
      head.keys.add(key);
    } else if (head.count != 0){
      Node init = new Node(0);
      init.keys.add(key);
      init.next = head;
      head.pre = init;
      head = init;
    } else {
      head.keys.add(key);
    }

    keyCountNode.put(key, head);
  }

  private void removeOld() {
    if(head == null) {
      return;
    }
    int old = 0;
    for(int key : head.keys) {
      old = key;
      break;
    }
    System.out.println("remove old " + old);
    head.keys.remove(old);
    keyValue.remove(old);
    keyCountNode.remove(old);

    if(head.keys.isEmpty()) {
      remove(head);
    }
  }

  private void increaseCount(int key) {
    Node countNode = keyCountNode.get(key);
    //remove key from this count
    countNode.keys.remove(key);

    if(countNode.next != null && countNode.next.count == countNode.count + 1) {
      //increased count node exist, insert the key
      countNode.next.keys.add(key);
    } else {
      //next node not exist
      //next node exist, but it is not next increased one
      appendNode(countNode, countNode.count + 1, key);
    }

    //update key node
    keyCountNode.put(key, countNode.next);

    //remove node if keys are empty
    if(countNode.keys.isEmpty()) {
      remove(countNode);
    }
  }

  public void appendNode(Node pre, int count, int key) {
    Node next = pre.next;

    Node increaseNode = new Node(count);
    increaseNode.keys.add(key);

    pre.next = increaseNode;
    increaseNode.pre = pre;

    if(next != null) {
      increaseNode.next = next;
      next.pre = increaseNode;
    }
  }

  public void remove(Node cur) {
    if(cur.pre == null) {
      //this is head
      head = cur.next;
      return;
    }
    Node next = cur.next;

    cur.pre.next = next;
    if(next != null) {
      next.pre = cur.pre;
    }
  }

  //keys for one count num
  private class Node {
    public int count;
    public LinkedHashSet<Integer> keys;
    public Node pre;
    public Node next;

    public Node(int count) {
      this.count = count;
      this.keys = new LinkedHashSet<Integer>();
    }MultiSet
  }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.set(key,value);
 */