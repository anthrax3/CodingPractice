package codeReview.Design;


import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by wangdong on 8/10/16.
 */
public class LRUCache1 {
  private class ValueIndex {
    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    private int value;
    private int key;

    public ValueIndex(int value, int key) {
      this.value = value;
      this.key = key;
    }
  }


  private LinkedList<ValueIndex> orderedKeys;
  private HashMap<Integer, ValueIndex> cache;
  private int capacity;

  public LRUCache1(int capacity) {
    orderedKeys = new LinkedList<>();
    cache = new HashMap<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if(!cache.containsKey(key)) {
      return -1;
    }
    ValueIndex info = cache.get(key);
    orderedKeys.remove(info);
    orderedKeys.add(0, info);

    return info.getValue();
  }

  public void set(int key, int value) {
    if(cache.containsKey(key)) {
      //update value
      ValueIndex info = cache.get(key);
      info.setValue(value);
      //move to head
      orderedKeys.remove(info);
      orderedKeys.add(0, info);
    } else {
      if(orderedKeys.size() < capacity) {
        //add to begin
        ValueIndex newInfo = new ValueIndex(value, key);
        orderedKeys.add(0, newInfo);
        cache.put(key, newInfo);
      } else {
        ValueIndex lastUsed = orderedKeys.pollLast();
        cache.remove(lastUsed.getKey());
        ValueIndex newInfo = new ValueIndex(value, key);
        cache.put(key, newInfo);
        orderedKeys.add(0, newInfo);
      }
    }
  }
}
