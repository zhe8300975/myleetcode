package medium.day12;

import java.util.ArrayList;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
public class LeetCode46 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        for (List<Integer> item : permute) {
            System.out.println(item.toString());
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dealPermute(nums, result, ans, used);
        return result;
    }

    public static void dealPermute(int[] nums, ArrayList<List<Integer>> result, ArrayList<Integer> ans, boolean[] used) {
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            ans.add(nums[i]);
            dealPermute(nums, result, ans, used);
            ans.remove(ans.size() - 1);
            used[i]=false;
        }

    }


}
