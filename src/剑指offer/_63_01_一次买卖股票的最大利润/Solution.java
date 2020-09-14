package 剑指offer._63_01_一次买卖股票的最大利润;

/**
 * 定义状态：dp[i]表示以prices[i]结尾的子数组的最大利润
 * 状态转移：dp[i] = max{dp[i−1], prices[i]−min(prices[0,i])} ,前i日最大利润=max{前(i−1)日最大利润, 第i日价格−前i日最低价格}
 */
public class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // 前i日最低价格
        int min = prices[0];
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(prices[i], min);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[n - 1];
    }
}
