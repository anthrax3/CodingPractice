package com.ms;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wangdong on 11/19/16.
 */
public class TreeSerializaeDeserTest {
  @Test
  public void testDes() {
    SerializeAndDeserializeBinaryTree coder = new SerializeAndDeserializeBinaryTree();
    Assert.assertEquals(null, coder.deserialize("1,null,3"));
  }

  @Test
  public void testSerial() {
    SerializeAndDeserializeBinaryTree coder = new SerializeAndDeserializeBinaryTree();
    Assert.assertEquals("null", coder.serialize(null));
  }
}
