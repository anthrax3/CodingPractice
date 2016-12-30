package com.ms;

/**
 * Created by wangdong on 11/25/16.
 */
public class PrimeCount {

  public int countPrimes(int n) {
    boolean[] isPrimes = new boolean[n];
    //1 is not prime
    for(int i = 2; i < n; i++) {
      isPrimes[i] = true;
    }

    //mark x*prime as none-prime
    //check from n*n
    //for example
    //current is 5
    //1*5, 2*5, 3*5, 4*5 already tested by 1,2,3,4
    for(int i = 2; i*i < n; i++) {
      //if current already marked, it means it part of previous one
      //4 is 2*2, so all x*4 should already been marked
      if(isPrimes[i] == false) {
        continue;
      }

      //if not mark until n
      for(int j = i*i; j < n; j += i) {
        isPrimes[j] = false;
      }
    }

    int count = 0;
    for(int i = 2; i < n; i++) {
      count += (isPrimes[i] == true ? 1 : 0);
    }

    return count;
  }
}
