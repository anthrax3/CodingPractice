package com.ms;

import java.util.Optional;

/**
 * Created by wangdong on 10/29/16.
 */
public class RingBufferForConsumerProducer<T> {
  private Object[] buffer;
  private int readStart = 0;
  private int writeEnd = 0;
  private int quantity = 0;

  public RingBufferForConsumerProducer(int capacity) {
    buffer = new Object[capacity];
  }

  public synchronized void write(T element) {
    while (quantity == 1) {
      try {
        super.wait();
      } catch (InterruptedException e) {

      }
    }
    quantity++;
    buffer[writeEnd] = element;
    //rotate to next write location
    System.out.println("write " + element);
    writeEnd = (writeEnd + 1)%buffer.length;
    super.notify();
  }

  public synchronized T read() {
    while (quantity == 0) {
      try {
        super.wait();
      } catch (InterruptedException e) {
        System.out.println("Read operation is interrupted");
      }
    }

    T content = (T)buffer[readStart];
    //rotate to next read location
    readStart = (readStart + 1)%buffer.length;
    quantity--;
    super.notify();
    return content;
  }
}
