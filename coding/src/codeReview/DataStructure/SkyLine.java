package codeReview.DataStructure;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangdong on 6/1/16.
 * http://www.faceye.net/search/72711.html#bottom-ad
 * http://www.cnblogs.com/shuaiwhu/archive/2012/04/22/2464583.html
 * 离散化的时候如果排完序后相邻的元素值不相邻的话，是不能离散为相邻的两个元素的
 *
 * 1 4 5 9
 *
 * => 1 2 3 4 is wrong
 * should be 1 3 4 6
 */
public class SkyLine {

  public List<int[]> getSkyline(int[][] buildings) {
    if(buildings == null || buildings.length == 0) {
      return new ArrayList<>();
    }

    List<Integer> xIndex = new ArrayList<>();
    for(int[] building : buildings) {
      xIndex.add(building[0]);
      xIndex.add(building[1]);
    }

    List<Integer> uniqueXIndex = xIndex.stream()
            .sorted().distinct().collect(Collectors.toList());

    Map<Integer, Integer> dispersedIdx = new HashMap<>();
    Map<Integer, Integer> recoverIdx = new HashMap<>();
    int dispersedKey = 1;
    dispersedIdx.put(uniqueXIndex.get(0), dispersedKey);
    recoverIdx.put(dispersedKey, uniqueXIndex.get(0));

    for (int i = 1; i < uniqueXIndex.size(); i++) {
      if(uniqueXIndex.get(i-1) + 1 == uniqueXIndex.get(i)) {
        //if value adjacent, the dispersed key can be adjacent
        dispersedKey += 1;
        dispersedIdx.put(uniqueXIndex.get(i), dispersedKey);
      } else {
        dispersedKey += 2;
        dispersedIdx.put(uniqueXIndex.get(i), dispersedKey);
      }
      recoverIdx.put(dispersedKey, uniqueXIndex.get(i));
    }

    SegmentTree tree = new SegmentTree();
    SegmentTree.Node root = tree.build(1, dispersedKey);

    for(int[] building : buildings) {
      //when insert, don't include the right boundary, if include will get error as we don't have mapping
      // for jump elements between keys
      tree.updateLeaf(root, dispersedIdx.get(building[0]), dispersedIdx.get(building[1])-1, building[2]);
    }
    List<int[]> res = new ArrayList<>();
    tree.getSkyLineResult(recoverIdx, root, res);
    return res;
  }
}
