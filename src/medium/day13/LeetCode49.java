package medium.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
// 示例:
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
public class LeetCode49 {

    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> item : lists) {
            System.out.println(item.toString());
        }


    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap();
        for (String item : strs) {
            String key = getKey(item);
            if (map.containsKey(key)) {
                map.get(key).add(item);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(item);
                map.put(key, list);
            }
        }
        ArrayList<List<String>> result = new ArrayList();
        for (List<String> item : map.values()) {
            result.add(item);
        }
        return result;
    }

    //
//    public static String sort(String str) {
//        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
//        return Arrays.toString(chars);
//    }

    public static String getKey(String str){
        int [] key= new int[str.length()];
        for(char car:str.toCharArray()){
            key[car-'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            sb.append('#');
            sb.append(key[i]);
        }
        return sb.toString();

    }
}
