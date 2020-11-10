package easy.day8;

import java.util.Arrays;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class LeetCode283 {
    public static void main(String[] args) {
        int[] text = new int[]{1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7};
        moveZeroes(text);
        System.out.println(Arrays.toString(text));

    }

    public static void moveZeroes(int[] nums) {
        for (int num = 0, i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int var = nums[num];
                nums[num] = nums[i];
                nums[i] = var;
                num++;
            }
        }
    }

//    public static void moveZeroes(int[] nums) {
//        int num = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[num++] = nums[i];
//            }
//        }
//        while (num < nums.length) {
//            nums[num++] = 0;
//        }
//    }
}
