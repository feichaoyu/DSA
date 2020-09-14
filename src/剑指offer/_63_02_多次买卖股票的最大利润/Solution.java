package 剑指offer._63_02_多次买卖股票的最大利润;

/**
 * 贪心算法，每次只买递增的
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
