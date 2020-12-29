package medium.day31;

//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
public class LeetCode647 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abcb"));
    }

    //中心扩展
    public static int countSubstrings(String s) {
        int ans = 0;
        for (int center = 0; center < 2 * s.length() + 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }


    //动态规划
//    public static int countSubstrings(String s) {
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int ans = 0;
//        for (int j = 0; j < s.length(); j++) {
//            for (int i = 0; i <= j; i++) {
//                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
//                    dp[i][j] = true;
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//

}
