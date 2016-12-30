package codeReview.backtracking;

import codeReview.Design.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by wangdong on 10/15/16.
 */
public class WordSearch2 {
  public void find(char[][] board, boolean[][] visited, Trie dic, HashSet<String> result, int i, int j, String current) {
    char newChar = board[i][j];
    current = current.concat(String.valueOf(newChar));

    //cut branch
    if(!dic.startsWith(current)) {
      return;
    }
    //add result
    if(dic.search(current)) {
      result.add(current);
    }

    int[] dxValues = {1, -1, 0, 0};
    int[] dyValues = {0, 0, 1, -1};
    int rows = board.length;
    int cols = board[0].length;

    for(int idx = 0; idx < 4; idx++) {
        int nextRow = i + dxValues[idx];
        int nextCol = j + dyValues[idx];
        if(nextRow >=0 &&
          nextRow < rows &&
          nextCol >= 0 &&
          nextCol < cols &&
          visited[nextRow][nextCol] == false) {

          visited[nextRow][nextCol] = true;
          find(board, visited, dic, result, nextRow, nextCol, new String(current));
          visited[nextRow][nextCol] = false;
        }

    }

    return;
  }


  public List<String> findWords(char[][] board, String[] words) {
    if(words == null || words.length == 0 || board.length == 0) {
      return new ArrayList<String>();
    }

    Trie dic = new Trie();
    for(String word : words) {
      dic.insert(word);
    }

    boolean[][] visited = new boolean[board.length][board[0].length];
    HashSet<String> result = new HashSet<>();


    for(int row = 0; row < board.length; row++) {
      for(int col = 0; col < board[0].length; col++) {
        visited[row][col] = true;
        find(board, visited, dic, result, row, col, new String());
        visited[row][col] = false;
      }
    }

    return new ArrayList<>(result);
  }
}
