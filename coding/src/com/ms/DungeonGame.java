package com.ms;

/**
 * Created by wangdong on 11/20/16.
 */
public class DungeonGame {
  //knight move right down
  //we calculate in a left up way from the princess location
  //do[i][j] means the lowes hp needed at i,j to reach princess

  public int calculateMinimumHP(int[][] dungeon) {
    int rows = dungeon.length;
    int cols = dungeon[0].length;


    int[][] dpMinHpAtLocation = new int[rows][cols];
    dpMinHpAtLocation[rows-1][cols-1] = dungeon[rows][cols] < 0 ? -dungeon[rows][cols] : 0;

    //backfill last row
    for(int col = cols-2; col >= 0; col--) {
      //if current is positive and can cover next jump, then this hp need to arrive this cell is zero
      dpMinHpAtLocation[rows-1][col] = Math.max(0, -dungeon[rows-1][col] + dpMinHpAtLocation[rows-1][col+1]);
    }

    //baclfill last col
    for(int row = rows-2; row >= 0; row--) {
      dpMinHpAtLocation[row][cols-1] = Math.max(0, -dungeon[row][cols-1] + dpMinHpAtLocation[row+1][cols-1]);
    }

    for(int row = rows-2; row >= 0; row--) {
      for(int col = cols-2; col >= 0; col--) {
        dpMinHpAtLocation[row][col] = Math.min(
                //move down
                Math.max(0, -dungeon[row][col] + dpMinHpAtLocation[row+1][col]),
                Math.max(0, -dungeon[row][col] + dpMinHpAtLocation[row][col+1])
        );
      }
    }

    return dpMinHpAtLocation[0][0] + 1;
  }
}
