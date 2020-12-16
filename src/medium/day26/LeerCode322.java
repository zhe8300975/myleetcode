package medium.day26;

import java.util.Arrays;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
//你可以认为每种硬币的数量是无限的。
public class LeerCode322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin == 0) {
                    dp[i] = 1;
                } else if (i - coin > 0 && dp[i - coin] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount];

    }
}
