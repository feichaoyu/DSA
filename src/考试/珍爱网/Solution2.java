package 考试.珍爱网;

public class Solution2 {

    public int saveZhenaiCoin(int[] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid.length == 1) {
            return grid[0];
        }

        int[] dp = new int[grid.length];
        dp[0] = grid[0];
        dp[1] = grid[1];
        for (int i = 2; i < grid.length; i++) {
            dp[i] = Math.min(dp[i - 1] + grid[i], dp[i - 2] + grid[i]);
        }

        return Math.min(dp[grid.length - 1], dp[grid.length - 2]);
    }
}
