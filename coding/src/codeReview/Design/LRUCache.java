package codeReview.Design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdong on 8/13/16.
 */
public class LRUCache {
  private class Node {
    Integer key;
    Integer value;
    Node pre;
    Node next;

    public Node () {}

    public Node (Integer key, Integer value) {
      this.key = key;
      this.value = value;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }

    public Node getPre() {
      return pre;
    }

    public void setPre(Node pre) {
      this.pre = pre;
    }

    private void removeNode() {
      //remove
      this.pre.setNext(this.next);
      this.next.setPre(this.pre);
    }

    private void insertNode(Node target) {
      this.next.setPre(target);
      target.setNext(this.next);
      target.setPre(this);
      this.setNext(target);
    }
  }


  int capacity;
  Node head;
  Node end;
  Map<Integer, Node> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new Node();
    end = new Node();
    head.setNext(end);
    end.setPre(head);
    cache = new HashMap<>();
  }


  public int get(int key) {
    if(cache.containsKey(key)) {
      Node target = cache.get(key);
      target.removeNode();
      head.insertNode(target);
      return target.value;
    } else {
      return -1;
    }
  }

  public void set(int key, int value) {
    if(cache.containsKey(key)) {
      Node target = cache.get(key);
      target.value = value;
      target.removeNode();
      head.insertNode(target);
    } else {
      if(cache.size() == capacity) {
        Node last = end.getPre();
        cache.remove(last.key);
        last.removeNode();

      }
      Node newNode = new Node(key, value);
      cache.put(key, newNode);
      head.insertNode(newNode);
    }
  }
}
