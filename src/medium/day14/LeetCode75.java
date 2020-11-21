package medium.day14;
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//进阶：
//
//你可以不使用代码库中的排序函数来解决这道题吗？
//你能想出一个仅使用常数空间的一趟扫描算法吗？

import java.util.Arrays;

public class LeetCode75 {

    public static void main(String[] args){
        int [] nums={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int index0 = 0, index1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int swap = nums[index1];
                nums[index1] = nums[i];
                nums[i] = swap;
                index1++;
            } else if (nums[i] == 0) {
                int swap = nums[index0];
                nums[index0] = nums[i];
                nums[i] = swap;
                if (index0 != index1) {
                    nums[i] = nums[index1];
                    nums[index1] = swap;
                }
                index0++;
                index1++;
            }
        }
    }
}
