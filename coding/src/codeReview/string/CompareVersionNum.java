package codeReview.string;

import java.util.regex.Pattern;

/**
 * Created by wangdong on 5/7/16.
 */
public class CompareVersionNum {
    public static int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) {
            return 0;
        }
        if(version1.isEmpty()) {
            return -1;
        }
        if(version2.isEmpty()) {
            return 1;
        }

        String[] v1Details = version1.contains(".") ? version1.split("\\.") : new String[] {version1};
        String[] v2Details = version2.contains(".") ? version2.split(Pattern.quote(".")) : new String[] {version2};

        // Append 0 for shorter one
        for(int i = 0; i < Math.max(v1Details.length, v2Details.length); i++) {

            int v1 = (i > v1Details.length - 1) ? 0 : Integer.valueOf(v1Details[i]);
            int v2 = (i > v2Details.length - 1) ? 0 : Integer.valueOf(v2Details[i]);


            if(v1 < v2) {
                return -1;
            }
            if(v1 > v2 ) {
                return 1;
            }
        }

        return 0;
    }
}
