package easy.day8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
//找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
//您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
public class LeetCode448 {
    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{1,2,3,4,5,5,5,6,7}).toString());
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index=Math.abs(nums[i])-1;
            if (nums[index] > 0) {
                nums[nums[index]] *= -1;
            }
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                arrayList.add(i+1);
            }
        }
        return arrayList;
    }

}
