package easy.day5;

//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//
//注意：你不能在买入股票前卖出股票。
public class LeetCode121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));

    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 0) {
            return result;
        }
        int currentMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (currentMin > prices[i]) {
                currentMin = prices[i];
            } else {
                result = Math.max(result, prices[i] - currentMin);
            }
        }
        return result;
    }

}
