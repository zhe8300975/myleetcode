package medium.day15;

import java.util.ArrayList;
import java.util.List;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
public class LeetCode78 {


    public static void main(String[] args) {

        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List item : subsets) {
            System.out.println(item.toString());
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        extract(nums, 0, result);
        return result;
    }

    public static void extract(int[] nums, int index, ArrayList<List<Integer>> result) {
        if (nums.length - 1 == index) {
            result.add(new ArrayList<>());
            ArrayList list = new ArrayList<>();
            list.add(nums[index]);
            result.add(list);
            return;
        } else {
            extract(nums, index + 1, result);
            int length = result.size();
            for (int i = 0; i < length; i++) {
                List<Integer> integers = result.get(i);
                ArrayList<Integer> arrayList = new ArrayList<>(integers);
                arrayList.add(nums[index]);
                result.add(arrayList);
            }
        }

    }
}
