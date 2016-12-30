package codeReview.graph;

import java.util.*;

/**
 * Created by wangdong on 5/4/16.
 */
public class CourseSchedule {
    private static final int UNVISITED = 0;
    private static final int START_VISIT = 1;
    private static final int END_VISIT = 2;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        //Find circle, use DFS, mark visited node, if a node is in stack and has been visited, have circle

        if(numCourses <= 1) {
            return true;
        }

        int[] status = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            status[i] = UNVISITED;
        }

        List<Set<Integer>> adjacentList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacentList.add(new HashSet<>());
        }

        for(int[] request : prerequisites) {
            //save each node's next hop info
            adjacentList.get(request[1]).add(request[0]);
        }


        //For each unvisited node, do a dfs
        for(int i = 0; i < numCourses; i++) {
            if(status[i] == UNVISITED) {
                if(true == dfsFindCircle(i, adjacentList, status)) {
                    return true;
                }
            }
        }
        return false;


    }

    private static boolean dfsFindCircle(int root, List<Set<Integer>> adjacentList, int[] status) {
        status[root] = START_VISIT;
        for(int neighbor : adjacentList.get(root)) {
            if(status[neighbor] == START_VISIT) {
                return true;
            }
            if(status[neighbor] == UNVISITED && dfsFindCircle(neighbor, adjacentList, status)) {
                //sub path has circle
                return true;
            }
        }
        status[root] = END_VISIT;

        return false;
    }

    //Use iteration and DFS
    public boolean canFinishStack(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            return true;
        }

        List<Set<Integer>> adjacentList = new ArrayList<>(new HashSet<>());
        for(int[] request : prerequisites) {
            adjacentList.get(request[1]).add(request[0]);
        }


        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for(int i = 0 ; i < numCourses; i++) {
            visited[i] = false;
            inStack[i] = false;
        }



        for(int course = 0; course < numCourses; course++) {
            if (findCircuitInDfsStack(course, adjacentList, visited, inStack)) {
                return false;
            }
        }

        return true;
    }

    public boolean findCircuitInDfsStack(int node, List<Set<Integer>> adjacentList, boolean[] visited, boolean[] inStack) {
        if(visited[node] == false) {
            inStack[node] = true;
            visited[node] = true;

            for(int neighbor : adjacentList.get(node)) {
                if(inStack[neighbor] == true || true == findCircuitInDfsStack(neighbor, adjacentList, visited, inStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    //Use BFS, delete all in degree 0 node, if still node left when all 0 degree nodes are deleted, then can't finish

}
