package medium.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
public class LeetCode17 {


    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        for (String item : list) {
            System.out.println(item);
        }
    }

    public static HashMap<Character, String> letters = new HashMap() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        addLetter(digits, new StringBuilder(), result);
        return result;
    }

    public static void addLetter(String digits, StringBuilder builder, ArrayList<String> result) {
        if (digits == null || digits.length() == 0) {
            return;
        }
        if (digits.length() == 1) {
            for (char chr : letters.get(digits.charAt(0)).toCharArray()) {
                builder.append(chr);
                result.add(builder.toString());
                builder.deleteCharAt(builder.length() - 1);
            }
        } else {
            for (char chr : letters.get(digits.charAt(0)).toCharArray()) {
                builder.append(chr);
                addLetter(digits.substring(1), builder, result);
                builder.deleteCharAt(builder.length() - 1);
            }
        }

    }

//    public static List<String> letterCombinations(String digits) {
//        if (digits == null || digits.length() == 0) {
//            return new ArrayList();
//        }
//        String letter = letters.get(digits.charAt(0));
//        ArrayList<String> result = new ArrayList<>();
//        if (digits.length() == 1) {
//            for (char chr : letter.toCharArray()) {
//                result.add(chr + "");
//            }
//        } else {
//            String str = digits.substring(1);
//            List<String> list = letterCombinations(str);
//            for (char chr : letter.toCharArray()) {
//                for (String item : list) {
//                    result.add(chr + item);
//                }
//            }
//            return result;
//        }
//        return result;
//    }

}
