package 分类刷题.回溯.解数独;

import com.sun.org.apache.regexp.internal.RE;

public class Solution1 {

    public void solveSudoku(char[][] board) {

        // 非法数独
        if (board == null || board.length != 9 || board[0] == null || board[0].length != 9) {
            return;
        }

        backtrace(board, 0, 0);
    }

    private boolean backtrace(char[][] board, int row, int col) {
        int n = board.length;
        // n=9
        // 当前行已全部试探过，换到下一行的第一个位置
        if (col == n) {
            return backtrace(board, row + 1, 0);
        }
        // 满足结束条件
        if (row == n) {
            return true;
        }
        // 这个位置数字已给出
        if (board[row][col] != '.') {
            // 试探当前行的下一个位置
            return backtrace(board, row, col + 1);
        }

        // 这个位置空缺，那么就找到合适的数填入
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, row, col, c)) {
                continue;
            }
            board[row][col] = c;

            if (backtrace(board, row, col + 1)) {
                return true;
            }

            // 回溯
            board[row][col] = '.';
        }
        return false;
    }

    /**
     * 判断 board[row][col]位置放入字符c是否合理，也就判断这个字符是否在「同一行，同一列，同一个3x3宫内」出现过
     *
     * @param board
     * @param row
     * @param col
     * @param c
     * @return
     */
    private boolean isValid(char[][] board, int row, int col, char c) {
        // 3x3方块索引 = (行/3) * 3 + 列/3
        // 遍历这个3x3方块
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) {
                return false;
            }
            if (board[i][col] == c) {
                return false;
            }
            // 这里不好理解
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
