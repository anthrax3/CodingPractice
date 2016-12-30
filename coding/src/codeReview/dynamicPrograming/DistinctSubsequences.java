package codeReview.dynamicPrograming;

/**
 * Created by wangdong on 5/10/16.
 */
public class DistinctSubsequences {
    //we can build a tree
    //abcd
    //Should from null to a, b, c, d each
    //For a it is something like, each part of the path is a subsequence
    /* a
         b  -> c
                 -> d
            -> d
         c  -> d
         d

    */
    public int numDistinctRecursive(String S, String T)
    {
        if(S.length() == 0) {
            return T.length() == 0 ? 1 : 0;
        }

        if(T.length() == 0) {
            //A empty string is a sub sequence of original string(delete all characters)
            return 1;
        }
        int num = 0;
        for(int i = 0; i < S.length(); i++) {
            if(T.charAt(0) == S.charAt(i)) {
                num += numDistinctRecursive(S.substring(i+1), T.substring(1));
            }
        }

        return num;
    }

    public int numDistinctDP(String S, String T) {
        //initialize S = 0, and T =0 length
        //For T length is j, we try to find sub sequence in i length S
        // 1. All j chars matched in i-1 length DP[i-1][j]
        // 2. All j chars matched until i, if so it means j can't find match in i-1
        // i and i-1 only diff one char and then that char i must match j, otherwise j should matched in first i-1 chars
        // As char j equals char i, then only need to match j-1 chars in first i-1 S
        // DP[i][j] = DP[i-1][j] + DP[i-1][j-1] if T(j) = S(i)

        return 0;
    }


}
