package 分类刷题.回溯.解数独;

public class Solution2 {

    // 三个布尔数组表明 行, 列, 还有 3*3 的方格的数字是否被使用过
    private boolean[][] rowUsed = new boolean[9][10];
    private boolean[][] colUsed = new boolean[9][10];
    private boolean[][][] boxUsed = new boolean[3][3][10];


    public void solveSudoku(char[][] board) {
        // 初始化
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int num = board[row][col] - '0';
                if (1 <= num && num <= 9) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;
                }
            }
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

        // 是空则尝试填充, 否则跳过继续尝试填充下一个位置
        if (board[row][col] == '.') {
            // 尝试填充1~9
            for (int num = 1; num <= 9; num++) {
                if (!rowUsed[row][num] && !colUsed[col][num] && !boxUsed[row / 3][col / 3][num]) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;

                    board[row][col] = (char) ('0' + num);
                    if (backtrace(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';

                    rowUsed[row][num] = false;
                    colUsed[col][num] = false;
                    boxUsed[row / 3][col / 3][num] = false;
                }
            }
        } else {
            return backtrace(board, row, col + 1);
        }
        return false;
    }

}
