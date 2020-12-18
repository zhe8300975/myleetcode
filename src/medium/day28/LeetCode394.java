package medium.day28;
//给定一个经过编码的字符串，返回它解码后的字符串。
//
//编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
//此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

import java.util.Collections;
import java.util.LinkedList;

public class LeetCode394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        LinkedList<String> list = new LinkedList<String>();
        int ptr = 0;
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                StringBuffer ret = new StringBuffer();
                while (Character.isDigit(s.charAt(ptr))) {
                    ret.append(s.charAt(ptr++));
                }
                list.addLast(ret.toString());
            } else if (Character.isLetter(cur) || cur == '[') {
                list.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(list.peekLast())) {
                    sub.addLast(list.removeLast());
                }
                Collections.reverse(sub);
                list.removeLast();
                int num = Integer.parseInt(list.removeLast());
                String str = getString(sub);
                StringBuffer t = new StringBuffer();
                while (num-- > 0) {
                    t.append(str);
                }
                list.addLast(t.toString());
                ptr++;
            }
        }
        return getString(list);
    }

    public static String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

}
