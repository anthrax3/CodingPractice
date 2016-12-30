package com.ms;

import java.util.Optional;

/**
 * Created by wangdong on 10/29/16.
 */
public abstract class AbstrackRingBuffer<T> {
  public abstract void write(T element);
  public abstract Optional<T> read();
}
