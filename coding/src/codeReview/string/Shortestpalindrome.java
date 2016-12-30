package codeReview.string;

/**
 * Created by wangdong on 5/7/16.
 */
public class Shortestpalindrome {
    //https://www.youtube.com/watch?v=c4akpqTwE5g
    public static  String shortestPalindrome(String s) {
        if(s.length() < 2) {
            return s;
        }

        String reversedS = new StringBuffer(s).reverse().toString();

        int prefix;
        for( prefix = 0; prefix < s.length(); prefix++) {
            int surfix = s.length() - prefix - 1;

            if(s.charAt(prefix) != reversedS.charAt(surfix)) {
                break;
            }
        }

        return reversedS.substring(0, s.length() - prefix) + s;
    }
}
