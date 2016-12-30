package codeReview.Sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntersectionOfTwoArray {
  public int[] intersection(int[] nums1, int[] nums2) {
    if(nums1 == null || nums2 == null) {
      return  new int[0];
    }

    Set<Integer> intersection = new HashSet<>();
    Set<Integer> num2Set = new HashSet<Integer>();
    for(int num :nums2) {
      num2Set.add(num);
    }

    for(int num : nums1) {
      if(num2Set.contains(num)) {
        intersection.add(num);
      }
    }
    int[] result = new int[intersection.size()];
    Iterator<Integer> iterator = intersection.iterator();
    int index = 0;
    while (iterator.hasNext()) {
      result[index++] = iterator.next();
    }

    return result;
  }

  public int[] intersection2(int[] nums1, int[] nums2) {
    if(nums1 == null || nums2 == null) {
      return  new int[0];
    }

    ArrayList<Integer> intersection = new ArrayList<>();
    ArrayList<Integer> num2Set = new ArrayList<>();
    for(int num :nums2) {
      num2Set.add(num);
    }

    for(int num : nums1) {
      int idx = num2Set.indexOf(num);
      if(idx != -1) {
        intersection.add(num);
        num2Set.remove(idx);
      }
    }
    int[] result = new int[intersection.size()];
    Iterator<Integer> iterator = intersection.iterator();
    int index = 0;
    while (iterator.hasNext()) {
      result[index++] = iterator.next();
    }

    return result;
  }
}
