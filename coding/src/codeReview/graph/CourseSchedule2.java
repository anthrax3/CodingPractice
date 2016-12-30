package codeReview.graph;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by wangdong on 5/3/16.
 */
public class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            return new int[]{};
        }

        //For 0 degree node, need to know its next nodes
        List<Set<Integer>> adjacentList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adjacentList.add(new HashSet<>());
        }

        for(int[] request : prerequisites) {
            adjacentList.get(request[1]).add(request[0]);
        }

        //may have duplicated edges, so calculate degree separately
        for(int course = 0; course < numCourses; course++) {
            for(int neighbor : adjacentList.get(course)) {
                inDegree[neighbor]++;
            }
        }


        Queue<Integer> beginningCourses = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                beginningCourses.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int count = 0;
        while (!beginningCourses.isEmpty()) {
            int beginCourse = beginningCourses.poll();
            order[count++] = beginCourse;

            for(int neighbour : adjacentList.get(beginCourse)) {
                inDegree[neighbour]--;

                if(inDegree[neighbour] == 0) {
                    beginningCourses.offer(neighbour);
                }
            }
        }

        //Topological sort should be a DAG, so first should do circle check
        if(count == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }
}
