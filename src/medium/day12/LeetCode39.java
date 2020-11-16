package medium.day12;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {
    public static void main(String[] args) {
        int[] list = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = combinationSum(list, 7);
        for (List<Integer> item : result) {
            System.out.println(item.toString());
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> selected = new ArrayList<>();
        combination(candidates, target, result, selected, 0);
        return result;
    }

    public static void combination(int[] candidates, int target, ArrayList<List<Integer>> result, ArrayList<Integer> selected, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(selected));
            return;
        }
        combination(candidates, target, result, selected, index + 1);
        if (target >= candidates[index]) {
            selected.add(candidates[index]);
            combination(candidates, target - candidates[index], result, selected, index);
            selected.remove(selected.size() - 1);
        }
    }


}
