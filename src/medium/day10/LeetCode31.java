package medium.day10;
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//必须原地修改，只允许使用额外常数空间。
//
//以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1


import java.util.Arrays;

public class LeetCode31 {


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }
        for (int k = nums.length - 1;i>0& k > i - 1; k--) {
            if (nums[i - 1] < nums[k]) {
                nums[i - 1] = nums[i - 1] + nums[k];
                nums[k] = nums[i - 1] - nums[k];
                nums[i - 1] = nums[i - 1] - nums[k];
                break;
            }
        }
        for (int k = 0; k < (nums.length-i)/2; k++) {
            int lastIndex = nums.length - 1 - k;
            nums[i+k] = nums[i+k] + nums[lastIndex];
            nums[lastIndex] = nums[i+k] - nums[lastIndex];
            nums[i+k] = nums[i+k] - nums[lastIndex];
        }


    }

}
