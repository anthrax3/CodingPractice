package com.uber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by wangdong on 9/28/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderingStringInSourceStringTest {
  OrderingStringInSourceString orderingStringInSourceString;
  @Before
  public void setUp() {
    orderingStringInSourceString = new OrderingStringInSourceString();
  }

  @Test
  public void test1() {
    Assert.assertTrue(orderingStringInSourceString.isContain("aaaabbbcccc", "ac"));
  }

  @Test
  public void test2() {
    Assert.assertFalse(orderingStringInSourceString.isContain("hello world!", "hlo!"));
  }

  @Test
  public void test3() {
    Assert.assertFalse(orderingStringInSourceString.isContain("hello world!", "!od"));
  }

  @Test
  public void test4() {
    Assert.assertTrue(orderingStringInSourceString.isContain("hello world!", "he!"));
  }
}