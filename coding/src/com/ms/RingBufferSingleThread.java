package com.ms;


import java.util.Optional;

/**
 * Created by wangdong on 10/29/16.
 */
public class RingBufferSingleThread<T> extends AbstrackRingBuffer<T>{
  private Object[] buffer;

  //initially point to the same Empty cell
  private int writeEnd = 0;
  private int readStart = 0;

  public RingBufferSingleThread(int capacity) {
    buffer = new Object[capacity+1];
  }

  @Override
  public void write(T element) {
    if((writeEnd + 1)%buffer.length == readStart) {
      throw new RuntimeException("buffer is full");
    }
    buffer[writeEnd] = element;
    writeEnd = (writeEnd + 1)%buffer.length;
  }

  @Override
  public Optional<T> read() {
    if(readStart == writeEnd) {
      //buffer is empty
      return Optional.empty();
    }
    T current = (T)buffer[readStart];
    readStart = (readStart+1)%buffer.length;

    return Optional.of(current);
  }
}
