package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 6/7/16.
 */
public class DungeonGame {
  public int calculateMinimumHP(int[][] dungeon) {
    if(dungeon == null || dungeon.length == 0) {
      return 0;
    }

    int rows = dungeon.length;
    int columns = dungeon[0].length;

    int[][] minHpNeedToReachThisSpot = new int[rows][columns];
    //TODO: From right down to left up !!!

    //initialize right down point
    minHpNeedToReachThisSpot[rows-1][columns-1] = Math.max(0, -dungeon[rows-1][columns-1]);
    //initialize last row
    for(int j = columns-2; j >=0; j--) {
      minHpNeedToReachThisSpot[rows-1][j] = Math.max(0, minHpNeedToReachThisSpot[rows-1][j+1] - dungeon[rows-1][j]);
    }
    //initialize last column
    for(int i = rows-2; i>=0; i--) {
      minHpNeedToReachThisSpot[i][columns-1] = Math.max(0, minHpNeedToReachThisSpot[i+1][columns-1] - dungeon[i][columns-1]);
    }

    for(int i = rows - 2; i >= 0; i--) {
      for (int j = columns - 2; j >= 0; j--) {
        minHpNeedToReachThisSpot[i][j] = Math.max(0,
                Math.min(minHpNeedToReachThisSpot[i+1][j], minHpNeedToReachThisSpot[j+1][i]) - dungeon[i][j]);
      }
    }

    return minHpNeedToReachThisSpot[0][0] + 1;


    /*
    //initialize first row
    for(int i = 0; i < columns; i++) {
      minHpNeedToReachThisSpot[0][i] = 1;
    }
    //initialize first column
    for(int j = 0; j < rows; j++) {
      minHpNeedToReachThisSpot[j][0] = 1;
    }

    for(int i = 0; i < dungeon.length; i++) {
      for(int j = 0; j < dungeon[0].length; j++) {
        minHpNeedToReachThisSpot[i+1][j+1] = Math.min(minHpNeedToReachThisSpot[i+1][j], minHpNeedToReachThisSpot[i][j+1]) + dungeon[i][j];
        if(minHpNeedToReachThisSpot[i+1][j+1] + minHp <= 0) {
          //have to bump up blood to reach this spot
        }
      }
    }
    */


  }
}
