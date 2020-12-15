package medium.day26;
//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//
//设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

import java.util.Arrays;

public class LeetCode309 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp=new int[3][prices.length];
        dp[0][0]=-prices[0];
        dp[1][0]=0;
        dp[2][0]=0;
        for(int i=1;i<prices.length;i++){
            dp[0][i]=Math.max(dp[0][i-1],dp[2][i-1]-prices[i]);
            dp[1][i]=dp[0][i-1]+prices[i];
            dp[2][i]=Math.max(dp[2][i-1],dp[1][i-1]);
        }
        return Math.max(dp[1][prices.length-1],dp[2][prices.length-1]);

    }


}
