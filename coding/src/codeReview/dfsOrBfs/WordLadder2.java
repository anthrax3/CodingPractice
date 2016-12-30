package codeReview.dfsOrBfs;

import java.util.List;
import java.util.Set;

/**
 * Created by wangdong on 5/10/16.
 */
public class WordLadder2 {
    // For one node, find it adjacent nodes (one word away)
    //1 BSF, for each node, track its parent node (used for backing tracking in DFS)
    // for each node track its distance for the start
    // for a node's parent nodes, it is valid in back tracing only when the distance is one unit less

    // Do back tracing from the end (DFS), add all valid path to the result group
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        return null;
    }

}
