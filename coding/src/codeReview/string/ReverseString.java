package codeReview.string;


public class ReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length;

        while(start < end) {
            char left = chars[start];
            chars[start] = chars[end];
            chars[end] = left;
            start++;
            end--;
        }

        return String.valueOf(chars);
    }
}
