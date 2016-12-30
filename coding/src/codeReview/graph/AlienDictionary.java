package codeReview.graph;

import java.util.*;

/**
 * Created by wangdong on 12/14/16.
 */
public class AlienDictionary {
  private class Node {
    public int inDegree;
    public List<Integer> adjacentList;
    public Node() {
      inDegree = 0;
      adjacentList = new ArrayList<Integer>();
    }
  }

  public String alienOrder(String[] words) {
    Node[] graph = new Node[26];
    boolean[] exist = new boolean[26];
    for (int i = 0; i < 26; i++) {
      graph[i] = new Node();
    }

    //build graph
    buildGraph(words, graph, exist);

        /*
        int existCount = 0;
        int zeroDegreeCount = 0;

        for(int i = 0; i < 26; i++) {
            if(exist[i]) {
                existCount++;
                if(graph[i].inDegree == 0) {
                    zeroDegreeCount++;
                }
            }
        }

        if(existCount == zeroDegreeCount && zeroDegreeCount > 1) {
            return "";
        }*/

    //topology sort, add 0 degree node, update adjacent node's degree
    Queue<Integer> traverse = new LinkedList<Integer>();
    StringBuffer res = new StringBuffer();

    //initialize the queue
    for(int i = 0; i < 26; i++) {
      if(exist[i] == true && graph[i].inDegree == 0) {
        traverse.offer(i);
        res.append((char)('a' + i));
      }
    }

    while(!traverse.isEmpty()) {
      //update degree
      int charNum = traverse.poll();
      for(int neighbor : graph[charNum].adjacentList) {
        graph[neighbor].inDegree--;
        if(graph[neighbor].inDegree == 0) {
          res.append((char)(neighbor + 'a'));
          traverse.offer(neighbor);
        }
      }
    }

    //check if any node left, if something left, it is invalid
    for(int i = 0; i < 26; i++) {
      if(graph[i].inDegree != 0) {
        System.out.println(String.format("line %s is %d", String.valueOf((char)(i + 'a')), graph[i].inDegree));
        return "";
      }
    }

    return res.toString();

  }

  public void buildGraph(String[] words, Node[] graph, boolean[] exist) {
    for(int i = 0; i < words.length; i++) {
      for(int j = 0; j < words[i].length(); j++) {
        exist[words[i].charAt(j) - 'a'] = true;
      }

      int source = 0;
      int destination = 0;

      if(i != words.length - 1) {
        //handle each char
        for(int j = 0; j < Math.min(words[i].length(), words[i+1].length()); j++) {
          source = words[i].charAt(j) - 'a';
          destination= words[i+1].charAt(j) - 'a';
          if(source != destination) {
            //only the first different char at the same location indicated the order
            graph[source].adjacentList.add(destination);
            graph[destination].inDegree++;

            //System.out.println(String.format("graph %s is %s", String.valueOf((char)(source + 'a')), String.valueOf((char)(destination + 'a'))));

            break;
          }
        }
      }
    }
  }
}
