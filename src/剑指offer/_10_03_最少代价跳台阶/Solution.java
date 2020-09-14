package 剑指offer._10_03_最少代价跳台阶;

public class Solution {

    public static int climbStairsWithLeastCost(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            // 如果第n个台阶是由跳1阶而来的，那么代价就是f(n-1)+a[n]
            // 如果第n个台阶是由跳2阶而来的，那么代价就是f(n-2)+a[n]
            // 由此可得：f(n) = min(f(n-1),f(n-2))+a[i]
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
