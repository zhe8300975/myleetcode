package easy;

//给定两个字符串 s 和 t，它们只包含小写字母。
//
//字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
//请找出在 t 中被添加的字母。
public class LeetCode389 {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abc", "acbd"));
    }

    public static char findTheDifference(String s, String t) {
        long num=0;
        for (char car : t.toCharArray()) {
            num+=(car-'a');
        }
        for (char car : s.toCharArray()) {
            num-=(car-'a');
        }
        return (char)('a'+num);
    }

//    public static char findTheDifference(String s, String t) {
//        int[] chars = new int[26];
//        for (char car : t.toCharArray()) {
//            chars[car - 'a']++;
//        }
//        for (char car : s.toCharArray()) {
//            chars[car - 'a']--;
//        }
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == 1) {
//                return (char) (i + 'a');
//            }
//        }
//        return 'a';
//    }
}
