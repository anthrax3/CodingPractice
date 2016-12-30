package codeReview.greedy;

/**
 * Created by wangdong on 11/11/16.
 * For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2.
 (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 我们可以使用贪心法来解决这个问题。

 从后往前思考问题。以 des = len - 1反向思考。思考能到达它的最远的距离是多少。

 例子：

 2 3 1 1 4

 i = 1

 上例子中index i = 1是达到4的最远的距离。这时index i = 1 到4是最后一步的最优解，
 因为其它的解，如果跳到index = 2, 3 到达4为最后一步，那么倒数第二步既然可以到达 index = 2, 3
 也可以到达index = 1，所以跳到index = 1步数会是一样的。所以其它的解最好的情况也就是与
 从index = 1跳过去一样而已。

 而前面的点因为距离限制 ，有可能只能跳到index = 1,而不可以跳到index = 2, 3.
 所以 将倒数第二步设置在index = 1可以得到最多的解。

 */
public class JumpGame2 {
  public int jump(int[] nums) {
    if(nums == null || nums.length == 0) {
      return 0;
    }

    int destIdx = nums.length-1;
    int totalJump = 0;

    while (destIdx > 0) {
      //find the most far away index can reach dest index
      //TODO for(int i = 0; i < nums.length; i++) {
      for(int i = 0; i < destIdx; i++) {
        if(i+nums[i] >= destIdx) {
          totalJump++;
          destIdx = i;
        }
      }
    }

    return totalJump;
  }
}
