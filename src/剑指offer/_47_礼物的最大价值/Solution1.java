package 剑指offer._47_礼物的最大价值;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Solution1 {

    private int row;

    private int column;

    private int[][] memo;

    public int maxValue(int[][] grid) {
        row = grid.length;
        column = grid[0].length;
        memo = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                memo[i][j] = -1;
            }
        }
        return calcTotal(0, 0, grid);
    }

    private int calcTotal(int curRow, int curColumn, int[][] grid) {

        // 走到右下角
        if (curRow == row - 1 && curColumn == column - 1) {
            memo[curRow][curColumn] = grid[curRow][curColumn];
            return memo[curRow][curColumn];
        }

        if (memo[curRow][curColumn] == -1) {
            // 默认给最小值
            int below = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            // 当前不是最后一行才可以继续向下走
            if (curRow != row - 1) {
                below = calcTotal(curRow + 1, curColumn, grid);
            }
            // 当前不是最后一列才可以继续向右走
            if (curColumn != column - 1) {
                right = calcTotal(curRow, curColumn + 1, grid);
            }
            // 不可能出现below=right=Integer.MIN_VALUE
            memo[curRow][curColumn] = Math.max(below, right) + grid[curRow][curColumn];
        }

        return memo[curRow][curColumn];
    }
}
