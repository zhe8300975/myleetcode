package medium.day29;
//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//注意:
//每个数组中的元素不会超过 100
//数组的大小不会超过 200
//示例 1:
//输入: [1, 5, 11, 5]
//输出: true
//解释: 数组可以分割成 [1, 5, 5] 和 [11].

import java.util.Arrays;

public class LeetCode416 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 4, 5, 11}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                Arrays.fill(dp[i], false);
                dp[i][0] = true;
                if (nums[i] <= sum / 2) {
                    dp[i][nums[i]] = true;
                }
            } else {
                Arrays.fill(dp[i], false);
                for (int index = 0; index <= sum/2; index++) {
                    if (dp[i - 1][index]) {
                        dp[i][index] = true;
                        if (index + nums[i] <= sum / 2) {
                            dp[i][index + nums[i]] = true;
                        }
                    }
                }
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (dp[index][sum / 2]) {
                return true;
            }
        }
        return false;
    }
}
