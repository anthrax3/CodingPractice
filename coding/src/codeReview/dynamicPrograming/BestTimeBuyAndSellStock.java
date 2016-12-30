package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 10/17/16.
 */
public class BestTimeBuyAndSellStock {
  //one transaction
  public int maxProfit1(int[] prices) {
    if(prices == null || prices.length == 0) {
      return 0;
    }
    int max = 0;
    int minPrice = prices[0];
    for(int price : prices) {
      max = Math.max(max, price - minPrice);
      minPrice = Math.min(minPrice, price);
    }

    return max;
  }

  //multiple transaction, greedy
  public int maxProfit2(int[] prices) {
    if(prices == null || prices.length == 0) {
      return 0;
    }
    int ans = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      if(prices[i] < prices[i+1]) {
        ans += (prices[i+1] - prices[i]);
      }
    }
    return ans;
  }

  //at most 2 transactions
  public int maxProfit3(int[] prices) {
    //devide in two part
    //1 max profix in first i days
    //2 max profix in remaining days
    if(prices == null || prices.length == 0) {
      return 0;
    }

    int[] maxProfitByToday = new int[prices.length];
    maxProfitByToday[0] = 0;
    int minPrice = prices[0];

    for(int i = 1; i < prices.length; i++) {
      maxProfitByToday[i] = Math.max(maxProfitByToday[i-1], prices[i] - minPrice);
      minPrice = Math.min(minPrice, prices[i]);
    }

    //the max price in remaining is maxPriceInTheFuture - currentPrice
    int maxPriceInTheFuture = prices[prices.length-1];
    int ans = 0;

    for (int i = prices.length-1; i >= 0; i--) {
      int profitInRest = maxPriceInTheFuture - prices[i];
      maxPriceInTheFuture = Math.max(maxPriceInTheFuture, prices[i]);
      ans = Math.max(maxProfitByToday[i] + profitInRest, ans);
    }

    return ans;
  }

  //at most K transactions
  public int maxProfit4(int k, int[] prices) {
    if(prices == null || prices.length == 0 || k == 0) {
      return 0;
    }

    if(k >= prices.length/2) {
      //enough transaction
      return maxProfit2(prices);
    }

    //dp[i][j] max profit of ith transaction at day j
    int[][] dp = new int[k+1][prices.length];

    //temp is current max profit
    //dp[i][j] = max(dp[i][j-1], prices[j] + temp)

    //if do buy, deduct price from previous max profit
    //else still max profix of i-1 transaction until j-1 day
    //temp = max(temp, dp[i-1][j-1] - prices[j])


    for(int time = 1; time <= k; time++) {
      //buy in
      int temp = - prices[0];
      for(int day = 1; day < prices.length; day++) {
        //Max(no transaction(happend before this day), happen this day, do see)
        dp[time][day] = Math.max(dp[time][day-1], temp + prices[day]);
        temp = Math.max(temp, dp[time-1][day-1] - prices[day]);
      }
    }

    return dp[k][prices.length-1];
  }
}
