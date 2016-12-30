package leetcode;

import codeReview.backtracking.WordSearch2;
import org.junit.Test;

/**
 * Created by wangdong on 10/15/16.
 */
public class WordSearch2Test {
  @Test
  public void test1() {
    WordSearch2 search2 = new WordSearch2();
    char[][] board = {
      {'o', 'a', 'a', 'n'},
      {'e', 't', 'a', 'e'},
      {'i', 'h', 'k', 'r'},
      {'i', 'f', 'l', 'v'}};

    String[] words = {"oath","pea","eat","rain"};
    search2.findWords(board, words);
  }

  @Test
  public void test2() {
    WordSearch2 search2 = new WordSearch2();
    char[][] board = {
            {'a', 'b'},
            {'c', 'd'}
    };

    String[] words = {"abcd"};
    search2.findWords(board, words);
  }
}
