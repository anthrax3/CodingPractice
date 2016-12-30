package codeReview.graph;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wangdong on 5/2/16.
 */
public class MinHeightTree {
    private static Integer currentMin;
    private final static Integer END_FLAG = -1;

    public List<Integer> findMinHeightTreesSlow(int n, int[][] edges) {
        if(n == 0 || edges == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> adjacentList = new HashMap<>();
        List<Integer> minTreeRoot = new ArrayList<>();

        for(int[] edge : edges) {
            adjacentList.putIfAbsent(edge[0], new ArrayList<>());
            adjacentList.get(edge[0]).add(edge[1]);

            adjacentList.putIfAbsent(edge[1], new ArrayList<>());
            adjacentList.get(edge[1]).add(edge[0]);
        }

        currentMin = n;
        for(int root : adjacentList.keySet()) {
            bsf(root, adjacentList, minTreeRoot, n);
        }

        return minTreeRoot;
    }

    public void bsf(int startRoot, Map<Integer, List<Integer>> adjacentList, List<Integer> minRoots, int n) {

        Queue<Integer> neighbours = new LinkedList<>();
        neighbours.add(startRoot);
        neighbours.add(END_FLAG);

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            visited[i] = false;
        }


        int currentHeight = 0;

        while (neighbours.size() != 1) {
            while (neighbours.peek() != END_FLAG) {
                Integer currentNode = neighbours.poll();

                visited[currentNode] = true;
                neighbours.addAll(adjacentList.get(currentNode).stream().filter(node -> visited[node] == false).collect(Collectors.toList()));
            }

            neighbours.poll();
            neighbours.add(END_FLAG);

            currentHeight++;
            if(currentHeight > currentMin) {
                return;
            }
        }

        if(currentHeight == currentMin) {
            minRoots.add(startRoot);
        } else if(currentHeight < currentMin) {
            minRoots.clear();
            minRoots.add(startRoot);
            currentMin = currentHeight;
        }

        return;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 0 || edges.length == 0) {
            return new ArrayList<>();
        }

        List<Set<Integer>> adjacentList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacentList.add(new HashSet<>());
        }

        for(int[] edge : edges) {
            adjacentList.get(edge[0]).add(edge[1]);
            adjacentList.get(edge[1]).add(edge[0]);
        }

        List<Integer> leafNodes = new ArrayList<>();
        for(int i = 0; i < adjacentList.size(); i++) {
            if(adjacentList.get(i).isEmpty() || adjacentList.get(i).size() == 1) {
                leafNodes.add(i);
            }
        }

        int remainingNodes = n;
        // root will be C  or A-B
        while (remainingNodes > 2) {
            remainingNodes -= leafNodes.size();
            List<Integer> newLeafNodes = new ArrayList<>();
            for(Integer leafNode : leafNodes) {
                int leafNeighbor = adjacentList.get(leafNode).iterator().next();
                adjacentList.get(leafNeighbor).remove(leafNode);
                if(adjacentList.get(leafNeighbor).size() == 1) {
                    newLeafNodes.add(leafNeighbor);
                }
            }

            leafNodes = newLeafNodes;
        }

        return leafNodes;
    }
}
