public class Main {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println((new Solution()).longestPalindrome(s));
    }
}

class Solution{
    public String longestPalindrome(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int maxStart = 0;
        int maxLen = 0;
        int len = 1;
        for(int i = 0; i < strLen; i++){
            left = i;
            right = i;
            while (left - 1 >= 0 && s.charAt(left - 1) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right + 1 < strLen && s.charAt(right + 1) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left - 1 >= 0 && right + 1 < strLen && s.charAt(right + 1) == s.charAt(left - 1)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart, maxStart+maxLen);
    }
}
