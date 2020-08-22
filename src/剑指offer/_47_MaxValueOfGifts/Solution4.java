package 剑指offer._47_MaxValueOfGifts;

/**
 * 原地动态规划
 *
 * @author feichaoyu
 */
public class Solution4 {

    public int maxValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                }
                // 第一行
                else if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
                // 第一列
                else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
                // 其他情况
                else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
