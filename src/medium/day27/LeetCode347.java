package medium.day27;

import java.util.*;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
public class LeetCode347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{5, -3, 9, 1, 7, 7, 9, 10, 2, 2, 10, 10, 3, -1, 3, 7, -9, -1, 3, 3}, 3)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer time = map.getOrDefault(num, 0);
            map.put(num, ++time);
        }
        ArrayList<Integer[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            list.add(new Integer[]{item.getValue(), item.getKey()});
        }
        //快排变种
        qcsort(list, 0, list.size() - 1, k);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1];
        }
        return result;
    }

    public static void qcsort(ArrayList<Integer[]> list, int start, int end, int k) {
        int point=end,index=start;
        for(int i=start;i<end;i++){
            if(list.get(i)[0]>=list.get(point)[0]){
                Collections.swap(list,index,i);
                index++;
            }
        }
        Collections.swap(list,index,point);

        if (index == k - 1) {
            return;
        } else if (index > k - 1) {
            qcsort(list, start, index - 1, k);
        } else {
            qcsort(list, index + 1, end, k);
        }
    }


}
