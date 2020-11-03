package medium.day5;

public class LeetCode6 {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 1));
    }

    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < numRows && i < s.length(); i++) {
            for (int column = 0; column * (numRows - 1)*2 + i < s.length(); column++) {
                chars[index++] = s.charAt(column * (numRows - 1)*2 + i);
                int k = (column + 1) * (numRows - 1)*2 - i;
                if (i != 0 && i != numRows - 1 && k < s.length()) {
                    chars[index++] = s.charAt(k);
                }
            }
        }
        return new String(chars);
    }
}
