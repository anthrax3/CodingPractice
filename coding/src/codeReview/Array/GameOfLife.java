package codeReview.Array;

/**
 * Created by wangdong on 7/31/16.
 *
 * find next state
 */
public class GameOfLife {
  private boolean isLive(int value) {
    if(value == 1 || value ==2) {
      return true;
    } else {
      return false;
    }
  }
  private int getNextState(int[][] board, int row, int column) {
    /*
    live 1 dead 0

     0 : die to die
     1 : live to live
     2 : live to die
     3 : die to live
     */
    int liveNeighbors = 0;

    int rows = board.length;
    int columns = board[0].length;

    for(int neighborRow = row - 1; neighborRow <= row + 1; neighborRow++) {
      for(int neighborColumn = column -1 ; neighborColumn <= column + 1; neighborColumn++) {
        if(neighborRow >= 0 && neighborRow < rows && neighborColumn >= 0 && neighborColumn < columns) {
          if(neighborRow == row && neighborColumn == column) {
            continue;
          }
          if(isLive(board[neighborRow][neighborColumn])) {
            liveNeighbors++;
          }
        }
      }
    }

    int currentNode = board[row][column];
    //Die
    if(liveNeighbors < 2 || liveNeighbors > 3) {
      if(isLive(currentNode)) {
        //live to die
        return 2;
      } else {
        //die to die
        return 0;
      }
    } else {
      //live to live
      if(isLive(currentNode)) {
        return 1;
      } else {
        if(liveNeighbors == 3) {
          //die to live
          return 3;
        } else {
          return 0;
        }
      }
    }
  }

  public void gameOfLife(int[][] board) {
    if(board == null || board.length == 0) {
      return;
    }


    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        board[i][j] = getNextState(board, i, j);
      }
    }

    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        board[i][j] = board[i][j]%2;
      }
    }

    return;
  }
}
