package 剑指offer._47_MaxValueOfGifts;

/**
 * 一维动态规划
 *
 * @author feichaoyu
 */
public class Solution3 {

    public int maxValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 起点
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                }
                // 第一行
                else if (i == 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                }
                // 第一列
                else if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                }
                // 其他情况
                else {
                    dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
