package com.ms;

import java.util.List;

/**
 * Created by wangdong on 11/15/16.
 *
 * https://segmentfault.com/a/1190000003786782
 *
 * 复杂度
 时间 O(NlogN) 空间 O(N)

 思路
 如果按照一个矩形一个矩形来处理将会非常麻烦，我们可以把这些矩形拆成两个点，一个左上顶点，一个右上顶点。
 将所有顶点按照横坐标排序后，我们开始遍历这些点。遍历时，通过一个堆来得知当前图形的最高位置。
 堆顶是所有顶点中最高的点，只要这个点没被移出堆，说明这个最高的矩形还没结束。对于左顶点，
 我们将其加入堆中。对于右顶点，我们找出堆中其相应的左顶点，然后移出这个左顶点，同时也意味这这个矩形的结束。
 具体代码中，为了在排序后的顶点列表中区分左右顶点，左顶点的值是正数，而右顶点值则存的是负数。

 注意
 堆中先加入一个零点高度，帮助我们在只有最矮的建筑物时选择最低值
 */
public class TheSkylineProblem {
  public List<int[]> getSkyline(int[][] buildings) {
    return null;
  }
}
