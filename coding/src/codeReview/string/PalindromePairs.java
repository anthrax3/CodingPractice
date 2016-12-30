package codeReview.string;

import java.util.*;

/**
 * Created by wangdong on 5/6/16.
 * http://bookshadow.com/weblog/2016/03/10/leetcode-palindrome-pairs/
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        if(words == null || words.length == 0) {
            return new ArrayList<>(new ArrayList<>());
        }

        Map<String, Integer> stringIdx = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            stringIdx.putIfAbsent(words[i], i);
        }

        List<List<Integer>> resultPairs = new ArrayList<>();

        for(String word : words) {
            String reverseWord = new StringBuffer(word).reverse().toString();
            if(!reverseWord.equals(word) && stringIdx.containsKey(reverseWord)) {
                resultPairs.add(Arrays.asList(stringIdx.get(word), stringIdx.get(reverseWord)));
            }

            if(isPalindrome(word)) {
                if(!word.equals("") && stringIdx.containsKey("")) {
                    resultPairs.add(Arrays.asList(stringIdx.get(word), stringIdx.get("")));
                    resultPairs.add(Arrays.asList(stringIdx.get(""), stringIdx.get(word)));
                }
            }


            for(int leftLength = 1; leftLength < word.length(); leftLength++) {
                String left = word.substring(0, leftLength);
                String right = word.substring(leftLength, word.length());

                if(isPalindrome(left)) {
                    String reverseRight = new StringBuffer(right).reverse().toString();
                    if(!reverseRight.equals(word) && stringIdx.containsKey(reverseRight)) {
                        resultPairs.add(Arrays.asList(stringIdx.get(reverseRight), stringIdx.get(word)));
                    }
                }

                if(isPalindrome(right)) {
                    String reverseLeft = new StringBuffer(left).reverse().toString();
                    if(!reverseLeft.equals(word) && stringIdx.containsKey(reverseLeft)) {
                        resultPairs.add(Arrays.asList(stringIdx.get(word), stringIdx.get(reverseLeft)));
                    }
                }
            }
        }

        return resultPairs;

    }

    private boolean isPalindrome(String word) {
        if(word == null || word.length() < 2) {
            return true;
        }

        char[] chars = word.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if(chars[start++] != chars[end--]) {
                return false;
            }
        }

        return true;
    }
}
