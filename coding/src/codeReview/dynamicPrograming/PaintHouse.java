package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 12/9/16.
 */
public class PaintHouse {
  public int minCost(int[][] costs) {
    //use dp[i][j] means when paint i+1 th house with color j, then min cost
    //when paint previous house, we can only use color j+1%3 and j+2%3
    //total cost for ith houst with j color is cost of current plus previous total cose
    //dp[i][j] = costs[i][j] + min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3])
    if(costs == null || costs.length == 0) {
      return 0;
    }

    int houses = costs.length;

    int dp[][] = new int[houses][3];

    for(int color = 0; color < 3; color++) {
      dp[0][color] = costs[0][color];
    }

    for(int house = 1; house < houses; house++) {
      for(int color = 0; color < 3; color++) {

        dp[house][color] = costs[house][color] + Math.min(dp[house-1][(color+1)%3], dp[house-1][(color+2)%3]);
      }
    }


    return Math.min(dp[houses-1][0], Math.min(dp[houses-1][1], dp[houses-1][2]));
  }
}
