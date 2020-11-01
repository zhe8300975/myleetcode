package medium.day3;
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abab"));
    }


    public static String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        int start = 0, end = 0;
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            for (int startIndex = 0; startIndex <= endIndex; startIndex++) {
                if (endIndex - startIndex == 0) {
                    dp[startIndex][endIndex] = true;
                } else if (endIndex - startIndex == 1) {
                    dp[startIndex][endIndex] = chars[startIndex] == chars[endIndex];
                } else {
                    dp[startIndex][endIndex] = chars[startIndex] == chars[endIndex] && dp[startIndex + 1][endIndex - 1];
                }
                if (dp[startIndex][endIndex] && (endIndex - startIndex) > (end - start)) {
                    start = startIndex;
                    end = endIndex;
                }
            }
        }
        return s.substring(start, end + 1);
    }

}
