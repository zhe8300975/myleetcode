package medium.day9;

import java.util.ArrayList;
import java.util.List;

//22. 括号生成 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class LeetCode22 {

    public static void main(String[] args) {
        List<String> list1 = generateParenthesis(3);
        for (String item : list1) {
            System.out.println(item);
        }
    }


    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list= new ArrayList<>();
        if (n != 0 || n != 1) {
            deal(1, 0, n, "(",list);
        }
        return list;
    }

    public static void deal(int before, int after, int n, String str,ArrayList list) {
        if (before == n && after == n - 1) {
            list.add(str + ")");
            return;
        }
        if (after == before) {
            deal(before + 1, after, n, str + "(",list);
            return;
        }
        if (before < n) {
            deal(before + 1, after, n, str + "(",list);
        }
        deal(before, after + 1, n, str + ")",list);
    }
}
