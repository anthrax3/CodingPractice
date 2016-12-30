package leetcode;

import codeReview.Design.LFUCache;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wangdong on 12/3/16.
 */
public class LFUTest {
  LFUCache cache;
  @Before
  public void setup() {
    cache = new LFUCache(2);
  }
  @Test
  public void setTest() {
    //[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
    cache.set(1,1);
    cache.set(2,2);
    cache.get(1);
    cache.set(3,3);
    cache.get(2);
    cache.get(3);
    cache.set(4,4);
  }
}
