package medium;

import java.util.*;

//所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
//
//编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC", "CCCCCAAAAA"]
public class LeetCode187 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }


    public static List<String> findRepeatedDnaSequences(String s) {
        int L=10;
        HashSet<String> out = new HashSet<>();
        HashSet<String> hashSet = new HashSet<>();
        for(int i=0;i<s.length()-L+1;i++){
            String str=s.substring(i,i+L);
            if(hashSet.contains(str)){
                out.add(str);
            }else{
                hashSet.add(str);
            }
        }
       return new ArrayList<String>(out);
    }



//        public static List<String> findRepeatedDnaSequences(String s) {
//        List<String> list = new ArrayList<>();
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < s.length() - 9; i++) {
//            String dna = s.substring(i, i + 10);
//            Integer num = hashMap.get(dna);
//            if (num == null) {
//                hashMap.put(dna, 1);
//            } else {
//                hashMap.put(dna, ++num);
//            }
//        }
//        for (Map.Entry<String, Integer> item : hashMap.entrySet()) {
//            if (item.getValue() > 1) {
//                list.add(item.getKey());
//            }
//        }
//        return list;
//    }
}
