package codeReview.string;

/**
 * Created by wangdong on 5/6/16.
 */
public class ReverseAEIOU {
    public class Solution {
        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int start = 0;
            int end = chars.length - 1;
            String vowels = "aeiou";

            while (start < end) {
                if(!vowels.contains(String.valueOf(chars[start]))) {
                    start++;
                    continue;
                }
                if(!vowels.contains(String.valueOf(chars[end]))) {
                    end--;
                    continue;
                }

                char left = chars[start];
                chars[start] = chars[end];
                chars[end] = left;
                start++;
                end--;
            }

            return String.valueOf(chars);
        }
    }
}
