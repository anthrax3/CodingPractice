package codeReview.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wangdong on 8/3/16.
 */
public class Sum {
  //naive N^2
  //Hashmap O(N) space and complexity
  //Sort array, check from both end, o(N*longN) + O(N), but need return index, sort will lose index info
  public int[] twoSum(int[] nums, int target) {
    if(nums == null || nums.length == 0) {
      return new int[]{};
    }

    //Assume has one solution, no conflict
    HashMap<Integer, Integer> keyIndex = new HashMap<>();
    int index = 0;

    //do check and put at the same time
    for(int num : nums) {
      if(keyIndex.containsKey(target-num)) {
        return new int[] {keyIndex.get(target-num), index};
      } else {
        keyIndex.put(num, index++);
      }
    }

    //not found
    return new int[] {};
  }

  //Sum of zero
  public List<List<Integer>> threeSum1(int[] nums) {
    if(nums == null || nums.length < 3) {
      return new ArrayList<>();
    }

    Arrays.sort(nums);
    Set<List<Integer>> results = new HashSet<>();

    //O(N^2)
    for(int first = 0; first < nums.length - 2; first++) {
      if(first > 0 && nums[first] == nums[first-1]) {
        //skip duplicate first element
        continue;
      }

      int second = first + 1;
      int third = nums.length - 1;
      while (second < third) {
        int sum = nums[first] + nums[second] + nums[third];
        if(sum == 0) {
          results.add(Arrays.asList(nums[first], nums[second], nums[third]));
          //update second and third
          second++;
          third--;
          while (second < nums.length && nums[second] == nums[second-1]) {
            second++;
          }
          while (third > second && nums[third] == nums[third+1]) {
            third--;
          }

        } else if (sum < 0) {
          second++;
          while (second < nums.length && nums[second] == nums[second-1]) {
            second++;
          }
        } else {
          //sum > 0
          third--;
          while (third > second && nums[third] == nums[third+1]) {
            third--;
          }
        }
      }
    }

    return new ArrayList<>(results);
  }

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length < 3) {
      return new ArrayList<>();
    }

    HashMap<Integer, Set<Set<Integer>>> sumValueIndex = new HashMap<>();

    for(int second = 0; second < nums.length-1; second++) {
      for(int third = second+1; third < nums.length; third++) {
        int sumTwo = nums[second] + nums[third];
        sumValueIndex.putIfAbsent(sumTwo, new HashSet<>());
        Set<Integer> pair = new HashSet<>();
        pair.add(second);
        pair.add(third);
        sumValueIndex.get(sumTwo).add(pair);
      }
    }

    Set<List<Integer>> res = new HashSet<>();
    for(int first = 0; first < nums.length; first++) {
      int twoSum = 0 - nums[first];
      if(sumValueIndex.containsKey(twoSum)) {
        for(Set<Integer> indexes : sumValueIndex.get(twoSum)) {
          if(!indexes.contains(first)) {
            List<Integer> oneRes = new ArrayList<>();
            oneRes.add(nums[first]);
            for(Integer idx : indexes) {
              oneRes.add(nums[idx]);
            }
            Collections.sort(oneRes);
            res.add(oneRes);
          }
        }
      }
    }


    return new ArrayList<>(res);
  }
}
