package codeReview.string;

/**
 * Created by wangdong on 5/9/16.
 */
public class PatternSearch1 {
    public static boolean searchPattern(String source, String pattern) {
        if(source.length() < pattern.length()) {
            return false;
        }

        for(int sourceIdx = 0; sourceIdx <= source.length() - pattern.length(); sourceIdx++) {
            if(source.substring(sourceIdx, sourceIdx + pattern.length()).equals(pattern)) {
                return true;
            }
        }

        return false;
    }
}
