package codeReview.Sort;

/**
 * Created by wangdong on 10/11/16.
 *
 * O(n) time and space
 *
 * linear sort algorithm
 * https://www.byvoid.com/blog/sort-radix
 *
 * http://www.geeksforgeeks.org/counting-sort/
 *
 */
public class MaximumGap {
  private class Bucket{
    Integer max = null;
    Integer min = null;
  }
  public int maximumGap(int[] nums) {
    if(nums.length < 2) {
      return 0;
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int num : nums) {
      if(num < min) {
        min = num;
      }
      if(num > max) {
        max = num;
      }
    }

    int bucketLength = (max-min)/nums.length + 1;
    int bucketNum = (max-min)/bucketLength + 1;

    Bucket[] buckets = new Bucket[bucketNum];
    for(int i = 0; i < bucketNum; i++) {
      buckets[i] = new Bucket();
    }
    for(int num : nums) {
      Bucket bucket = buckets[(num-min)/bucketLength];
      if(bucket.max == null) {
        bucket.max = num;
        bucket.min = num;
        continue;
      }
      bucket.max = Math.max(bucket.max, num);
      bucket.min = Math.min(bucket.min, num);
    }

    int maxGap = 0;
    Integer preIndex = null;
    for(int i = 0; i < buckets.length; i++) {
      Bucket cur = buckets[i];
      if(cur.max == null) {
        continue;
      }

      if(preIndex != null) {
        Bucket pre = buckets[preIndex];
        maxGap = Math.max(maxGap, cur.min - pre.max);
      }
      preIndex = i;
    }

    return maxGap;

  }
}
