package easy.day7;
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

public class LeetCode198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 0;
        int max = nums.length * 400 + 1;
        boolean[][] dp = new boolean[nums.length][max];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i == 1) {
                dp[i][nums[i]] = true;
                result = Math.max(result, nums[i]);
            } else {
                if (i - 2 >= 0) {
                    for (int k = 0; k < max; k++) {
                        if (dp[i - 2][k]) {
                            dp[i][k + nums[i]] = true;
                            result = Math.max(result, k + nums[i]);
                        }
                    }
                }
                if (i - 3 >= 0) {
                    for (int k = 0; k < max; k++) {
                        if (dp[i - 3][k]) {
                            dp[i][k + nums[i]] = true;
                            result = Math.max(result, k + nums[i]);
                        }
                    }
                }
            }
        }
        return result;
    }
}
