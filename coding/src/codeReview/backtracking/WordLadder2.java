package codeReview.backtracking;


import java.util.*;
import java.util.stream.Collectors;

public class WordLadder2 {
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        List<String> initialList = new ArrayList<>();
        initialList.add(beginWord);

        findNextLadders(beginWord, endWord, wordList, initialList, result);

        int shortest =  result.stream().map(list -> list.size()).sorted().findFirst().orElse(0);
        return result.stream().filter(list -> list.size() == shortest).collect(Collectors.toList());
    }

    private static void findNextLadders(String begin, String end, Set<String> words, List<String> pre, List<List<String>> result) {
        if(oneCharAway(begin, end)) {
            pre.add(end);

            result.add(pre);
            return;
        }

        if(words.isEmpty()) {
            return;
        }

        Iterator<String> wordIterator = words.iterator();

        while (wordIterator.hasNext()) {
            String word = wordIterator.next();
            if(oneCharAway(begin, word)) {
                List<String> current = new ArrayList<>(pre);
                current.add(word);
                Set<String> dic = new HashSet<>(words);//backtracking
                dic.remove(word);
                findNextLadders(word, end, dic, current, result);

            }
        }

        return;

    }

    private static boolean oneCharAway(String begin, String end) {

        char[] beginChars = begin.toCharArray();
        char[] endChars = end.toCharArray();
        int diff = 0;

        for(int i = 0; i < beginChars.length; i++) {
            if(beginChars[i] != endChars[i]) {
                diff++;
            }
            if(diff > 1) {
                return false;
            }
        }

        return true;
    }
}
