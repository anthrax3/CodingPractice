package codeReview.Tree;

/**
 * Created by wangdong on 10/31/16.
 */
public class UniqueBinarySearchTrees {
  public int numTrees(int n) {
    //dp[i] is the nums of trees for i nodes
    // dp i = dp[j] * dp[i-1-j]
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for(int i = 1; i <= n; i++) {
      for(int left = 0; left < i; left++) {
        int right = i-1-left;
        dp[i] += dp[left] * dp[right];
      }
    }

    return dp[n];
  }
}
