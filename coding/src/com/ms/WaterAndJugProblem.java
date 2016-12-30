package com.ms;

/**
 * Created by wangdong on 11/13/16.
 */
public class WaterAndJugProblem {
  public boolean canMeasureWater(int x, int y, int z) {
    return (x+y == z) || (x+y >= z && z%gcd(x, y) == 0);
  }

  private int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x%y);
  }
}
