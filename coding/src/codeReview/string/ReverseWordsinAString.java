package codeReview.string;

/**
 * Created by wangdong on 5/7/16.
 */
public class ReverseWordsinAString {
    private void swap(char[] word, int start, int end) {
        while (start <= end) {
            char temp = word[end];
            word[end] = word[start];
            word[start] = temp;
            start++;
            end--;
        }
    }
    public String reverseWords(String s) {
        s = s.trim();
        if(s == null || s.length() ==  1) {
            return s;
        }

        char[] string = s.toCharArray();
        swap(string, 0, string.length-1);

        int start = 0;
        for(int i = 0; i <= s.length(); i++) {
            if(i == s.length() || string[i] == ' ') {
                swap(string, start, i-1);
                start = i + 1;
            }
        }

        //remove space between words
        int reverseStart = 0;
        for(int i = 0; i < string.length; i++) {
            if(string[i] != ' ' ||
                    (string[i] == ' ' && string[i-1] != ' ')) {
                string[reverseStart++] = string[i];
            }
        }

        return String.valueOf(string, 0, reverseStart);
    }

}
