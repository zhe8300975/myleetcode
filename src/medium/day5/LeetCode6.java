package medium.day5;

public class LeetCode6 {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < numRows && i < s.length(); i++) {
            int stepping = 2 * (numRows - i - 1) > 0 ? 2 * (numRows - i - 1) : 2 * (numRows - 1);
            for (int k = i; k < s.length(); k += stepping) {
                chars[index++] = s.charAt(k);
            }
        }
        return new String(chars);
    }
}
