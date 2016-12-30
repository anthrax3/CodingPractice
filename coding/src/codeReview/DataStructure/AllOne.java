package codeReview.DataStructure;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangdong on 10/19/16.
 */

/*public class AllOne {

  private class  Node {
    public Node pre;
    public Node next;
    public String key;
    public Node (String key){
      key = key;
      pre = null;
      next = null;
    }
  }

  private class Row {
    public Integer value;
    public ArrayList<Node> keyNodes;
    public Row (int value){
      keyNodes = new ArrayList<>();
      this.value = value;
    }

    public void appendNode(Node node) {
      if(keyNodes.isEmpty()) {
        keyNodes.add(node);
      } else {
        Node last = keyNodes.get(keyNodes.size() - 1);
        last.next = node;
        node.pre = last;
        keyNodes.add(node);
      }
    }
  }

  private List<Row> matrix;
  private HashMap<String, Pair<Row, Node>> keyLocation;

  *//** Initialize your data structure here. *//*
  public AllOne() {
    keyLocation = new HashMap<>();
    matrix = new LinkedList<>();
  }

  *//** Inserts a new key <Key> with value 1. Or increments an existing key by 1. *//*
  public void inc(String key) {
    if(!keyLocation.containsKey(key)) {
      //insert if matrix is empty
      if(matrix.isEmpty()) {
        Node firstNode = new Node(key);
        Row firstRow = new Row(1);
        firstRow.appendNode(firstNode);
        matrix.add(firstRow);
        keyLocation.put(key, Pair.of(firstRow, firstNode));
      } else {
        //matrix is not empty, find first row
        if(matrix.get(0).value == 1) {
          //add to first row
          Node newNode = new Node(key);
          Row firstRow = matrix.get(0);
          firstRow.appendNode(newNode);
          keyLocation.put(key, Pair.of(firstRow, newNode));
        } else {
          //insert row to then front
          Node firstNode = new Node(key);
          Row firstRow = new Row(1);
          firstRow.appendNode(firstNode);
          matrix.add(0, firstRow);
          keyLocation.put(key, Pair.of(firstRow, firstNode));
        }
      }
    } else {
      //contain the key
      Row cur = keyLocation.get(key).getLeft();
      Node node = keyLocation.get(key).getRight();
      if(node.pre != null) {
        node.pre.next = node.next;
      }
      if(node.next != null) {
        node.next.pre = node.pre;
      }

      matrix.indexOf(cur);
    }
  }

  *//** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. *//*
  public void dec(String key) {

  }

  *//** Returns one of the keys with maximal value. *//*
  public String getMaxKey() {

  }

  *//** Returns one of the keys with Minimal value. *//*
  public String getMinKey() {

  }
}*/
