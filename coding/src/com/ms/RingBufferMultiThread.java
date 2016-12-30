package com.ms;

import java.util.Optional;

/**
 * Created by wangdong on 10/29/16.
 */
public class RingBufferMultiThread<T> extends AbstrackRingBuffer<T> {
  private Object[] buffer;
  private int readStart = 0;
  private int writeEnd = 0;
  private int quantity = 0;

  public RingBufferMultiThread(int capacity) {
    buffer = new Object[capacity];
  }

  public synchronized void write(T element) {
    if(quantity == buffer.length) {
      throw new RuntimeException("Buffer is full");
    }
    quantity++;
    buffer[writeEnd] = element;
    //rotate to next write location
    writeEnd = (writeEnd + 1)%buffer.length;

  }

  public synchronized Optional<T> read() {
    if(quantity == 0) {
      return Optional.empty();
    }

    T content = (T)buffer[readStart];
    //rotate to next read location
    readStart = (readStart + 1)%buffer.length;
    quantity--;
    return Optional.of(content);
  }
}
