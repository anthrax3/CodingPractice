package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 5/11/16.
 */
public class InterleavingString {
    public boolean isInterleaveRecursive(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) {
            return false;
        }

        if(s3.isEmpty()) {
            return true;
        }
        boolean isInterleave = false;

        if(!s1.isEmpty() && s1.charAt(0) == s3.charAt(0)) {
            isInterleave |= isInterleaveRecursive(s1.substring(1), s2, s3.substring(1));
        }

        if(!s2.isEmpty() && s2.charAt(0) == s3.charAt(0)) {
            isInterleave |= isInterleaveRecursive(s1, s2.substring(1), s3.substring(1));
        }

        return isInterleave;
    }

    public boolean isInterleave(String s1, String s2, String s3)
    {
        if(s3.length() != s1.length() + s2.length()) {
            return false;
        }
        if(s3.length() == 0) {
            return true;
        }

        boolean[][] map = new boolean[s1.length()+1][s2.length()+1];
        //For 0 length s3, 0 char from s1, 0 from s2, it is interleave
        map[0][0] = true;



        for(int i = 1; i <= s1.length(); i++) {
            //Match s3 against, get 0 char form s2, get all other chars from s1
            if(s1.charAt(i-1) == s3.charAt(i-1)) {
                //If current char match, whole strings whether interleave depends on previous char
                map[i][0] = map[i-1][0];
            } else {
                map[i][0] = false;
            }
        }

        for(int j = 1; j <= s2.length(); j++) {
            if(s2.charAt(j-1) == s3.charAt(j-1)) {
                map[0][j] = map[0][j-1];
            } else {
                map[0][j] = false;
            }
        }

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                //current s3's length is i+j, it gets i chars from s1 and j chars from s2

                if(s3.charAt(i+j-1) == s1.charAt(i-1)) {
                    //if last s3 char math s1's last char, means previously i+j-1 length s3 get i -1 char from s1 and j char from s2
                    map[i][j] |= map[i-1][j];
                }

                if(s3.charAt(i+j-1) == s2.charAt(j-1)) {
                    map[i][j] |= map[i][j-1];
                }
            }
        }

        //S3 get s1 length char from s1 and s2 length char from s2
        return map[s1.length()][s2.length()];
    }
}
