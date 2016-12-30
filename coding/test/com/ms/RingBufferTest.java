package com.ms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by wangdong on 10/29/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class RingBufferTest {
  @Test
  public void testOpereateBuffer() {
    RingBufferSingleThread<String> buffer = new RingBufferSingleThread<>(2);

    Assert.assertTrue(!buffer.read().isPresent());
    buffer.write("abc");
    buffer.write("def");
    Assert.assertEquals("abc", buffer.read().get());
    Assert.assertEquals("def", buffer.read().get());
    Assert.assertFalse(buffer.read().isPresent());
  }

  @Test
  public void testOpereateBufferOneThread() {
    RingBufferMultiThread<String> buffer = new RingBufferMultiThread<>(2);

    Assert.assertTrue(!buffer.read().isPresent());
    buffer.write("abc");
    buffer.write("def");
    Assert.assertEquals("abc", buffer.read().get());
    Assert.assertEquals("def", buffer.read().get());
    Assert.assertFalse(buffer.read().isPresent());
  }

  @Test
  public void testOpereateBufferMultiThread() {
    RingBufferMultiThread<String> buffer = new RingBufferMultiThread<>(2);

    Runnable read1 = new Runnable() {
      @Override
      public void run() {
        System.out.println(String.format("Runnable 1 start to read.."));
        System.out.println(String.format("R1 read %s", buffer.read().orElse("Empty")));

        System.out.println(String.format("Runnable 1 start to sleep.."));
        try {
          Thread.sleep(1000);
        }catch (InterruptedException e) {
        }
        System.out.println(String.format("Runnable 1 end sleep.."));
      }
    };

    Runnable read2 = new Runnable() {
      @Override
      public void run() {
        System.out.println(String.format("Runnable 2 start to read.."));
        System.out.println(String.format("R2 read %s", buffer.read().orElse("Empty")));
      }
    };

    Runnable write = new Runnable() {
      @Override
      public void run() {
        System.out.println(String.format("Runnable 3 start to write.."));
        buffer.write("abc");
        System.out.println(String.format("R3 write abc"));
      }
    };

    write.run();
    read1.run();
    read2.run();
  }

  @Test
  public void testOpereateBufferConsumerProducer() {
    RingBufferForConsumerProducer<String> buffer = new RingBufferForConsumerProducer(2);

    Runnable producer = new ConsumerRunnable(buffer);

    Runnable consumer = new ProducerRunable(buffer);


    new Thread(producer).start();
    System.out.println("producer start sleep");
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      System.out.println("interrupted");
    }
    new Thread(consumer).start();
  }

  private static class ConsumerRunnable implements Runnable {
    private final RingBufferForConsumerProducer<String> buffer;

    public ConsumerRunnable(RingBufferForConsumerProducer<String> buffer) {
      this.buffer = buffer;
    }

    @Override
    public void run() {

      buffer.write("ab");

      buffer.write("cd");

      buffer.write("ef");
    }
  }

  private static class ProducerRunable implements Runnable {
    private final RingBufferForConsumerProducer<String> buffer;

    public ProducerRunable(RingBufferForConsumerProducer<String> buffer) {
      this.buffer = buffer;
    }

    @Override
    public void run() {
      System.out.println("consumer read 1 " + buffer.read());
      System.out.println("consumer read 2 " + buffer.read());
      System.out.println("consumer read 3 " + buffer.read());
    }
  }
}
