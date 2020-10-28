package easy;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。你可以假定该字符串只包含小写字母。
public class LeetCode384 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] list = new int[26];
        char[] chars = s.toCharArray();
        for (char car : chars) {
            list[car - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (list[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
