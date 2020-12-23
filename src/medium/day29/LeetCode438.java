package medium.day29;

import java.util.ArrayList;
import java.util.List;
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
//字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
//说明：
//
//字母异位词指字母相同，但排列不同的字符串。
//不考虑答案输出的顺序。

public class LeetCode438 {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        List<Integer> ans = new ArrayList<>();
        int[] needs = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            window[curR]++;
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                window[curL]--;
            }
            if (right - left == arrP.length) {
                ans.add(left);
            }

        }
        return ans;

    }
}
