package 剑指offer._47_MaxValueOfGifts;

/**
 * 二维动态规划
 * 状态方程：dp[i][j]表示达到grid[i][j]所能获取的最大价值
 * 状态转移：dp[i][j] = max{ dp[i-1][j], dp[i][j-1] } + grid[i][j]
 * <p>
 * 类似力扣64题 https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int maxValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 起点
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                // 第一行
                else if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }
                // 第一列
                else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }
                // 其他情况
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 5},
                {3, 2, 1}
        };
        System.out.println(new Solution2().maxValue(arr));
    }
}
