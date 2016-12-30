package codeReview.dfsOrBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangdong on 7/6/16.
 *
 * 1. 从四条边上的O元素开始BFS，所有相连的O都赋个新值，比如‘Y’
 2. 扫描整个数组，所有现存的O元素全部置为X，所有Y元素置为O
 打完收工。代码实现如下：
 */
public class SurroundedRegions {
  private class Location {
    public int x;
    public int y;
    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public void solve(char[][] board) {
    if(board == null || board.length == 0) {
      return;
    }

    int rows = board.length;
    int columns = board[0].length;
    boolean[][] visited = new boolean[rows][columns];
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        visited[i][j] = false;
      }
    }

    Queue<Location> bfs = new LinkedList<>();
    Queue<Location> locations = new LinkedList<>();
    boolean surrounded;

    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        if(board[i][j] != 'X' && visited[i][j] == false) {
          bfs.add(new Location(i,j));
          surrounded = true;

          while (!bfs.isEmpty()) {
            Location location = bfs.poll();
            if(location.x < 0 || location.x >= rows || location.y < 0 || location.y >= columns) {
              continue;
            }
            if(visited[location.x][location.y] || board[location.x][location.y] == 'X') {
              continue;
            }

            if(location.x == 0 || location.x == rows-1 || location.y == 0 || location.y == columns-1) {
              //point is at the boundry, mark the bsf false
              surrounded = false;
            }

            visited[location.x][location.y] = true;
            //add valid visited point
            locations.add(location);
            int x = location.x;
            int y = location.y;
            bfs.add(new Location(x-1, y));
            bfs.add(new Location(x+1, y));
            bfs.add(new Location(x, y - 1));
            bfs.add(new Location(x, y + 1));
          }

          if(surrounded == true) {
            while (!locations.isEmpty()) {
              Location location = locations.poll();
              board[location.x][location.y] = 'X';
            }
          } else {
            locations = new LinkedList<>();
          }
        }
      }
    }
  }
}
