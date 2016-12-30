package com.ms;

/**
 * Created by wangdong on 11/14/16.
 *
 *
 CareerCup上的原题，请参见我之前的博客17.2 Tic Tac Toe。我们首先来O(n2)的解法，
 这种方法的思路很straightforward，就是建立一个nxn大小的board，其中0表示该位置没有棋子，
 1表示玩家1放的子，2表示玩家2。那么棋盘上每增加一个子，我们都每行每列，
 对角线和逆对角线来扫描一遍棋盘，看看是否有三子相连的情况，有的话则返回对应的玩家，
 没有则返回0，参见代码如
 *
 * ---------
 * |*      *
 * | *    *
 * |  *  *
 * |    *
 *     *  *
 * A move is guaranteed to be valid and is placed on an empty block.
 Once a winning condition is reached, no more moves is allowed.
 A player who succeeds in placing n of their marks in a horizontal,
 vertical, or diagonal row wins the game.
 */

public class TicTacToe {
  private int[] rows;
  private int[] cols;
  private int diagonal;
  private int antiDiagonal;
  int n;
  /** Initialize your data structure here. */
  public TicTacToe(int n) {
    rows = new int[n];
    cols = new int[n];
    diagonal = 0;
    antiDiagonal = 0;
    this.n = n;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {

    int change = player == 1 ? 1 : -1;
    rows[row] += change;
    cols[col] += change;
    if(row == col) {
      diagonal += change;
    }
    if(row == n - 1 - col) {
      antiDiagonal += change;
    }


    if(Math.abs(rows[row]) == n ||
       Math.abs(cols[col]) == n ||
       Math.abs(diagonal) == n ||
       Math.abs(antiDiagonal) == n) {
      return player;
    }

    return 0;
  }
}

