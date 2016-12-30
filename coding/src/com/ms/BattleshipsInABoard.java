package com.ms;

/**
 * Created by wangdong on 11/14/16.
 *
 * You receive a valid board, made of only battleships or empty slots.
 Battleships can only be placed horizontally or vertically.
 In other words, they can only be made of the shape 1xN (1 row, N columns) or
 Nx1 (N rows, 1 column), where N can be of any size.
 At least one horizontal or vertical cell separates between two battleships -
 there are no adjacent battleships.

 */
public class BattleshipsInABoard {
  //find the board head, which means the top and left must be empty
  public int countBattleships(char[][] board) {
    if(board == null || board.length == 0 || board[0].length == 0) {
      return 0;
    }

    int count = 0;
    for(int row = 0; row < board.length; row++) {
      for(int col = 0; col < board[0].length; col++) {
        if(board[row][col] == '.' ||
                (row > 0 && board[row-1][col] == 'X' ) ||
                (col > 0 && board[row][col-1] == 'X')) {
          continue;
        }
        count++;
        /*
        if(board[row][col] == 'X') {
          //check whether it is head
          if(row == 0 && col == 0) {
            count++;
          } else if (row == 0 && board[row][col-1] == '.') {
            count++;
          } else if (col == 0 && board[row-1][col] == '.') {
            count++;
          } else if(row > 0 && col > 0 && board[row][col-1] == '.' && board[row-1][col] == '.') {
            count++;
          }
        }
        */
      }
    }

    return count;
  }
}
