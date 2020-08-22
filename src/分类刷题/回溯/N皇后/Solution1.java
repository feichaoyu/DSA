package 分类刷题.回溯.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    /**
     * 列，col[i]表示第i列
     */
    private boolean[] col;

    /**
     * 主对角线(左上至右下)，mainDia[i]表示第i条主对角线
     */
    private boolean[] mainDia;

    /**
     * 副对角线(左下至右上)，subDia[i]表示第i条副对角线
     */
    private boolean[] subDia;

    private ArrayList<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();
        col = new boolean[n];
        // 对角线有2n-1条
        subDia = new boolean[2 * n - 1];
        mainDia = new boolean[2 * n - 1];

        LinkedList<Integer> row = new LinkedList<>();
        putQueen(n, 0, row);

        return res;
    }

    /**
     * 在一个n皇后问题中，摆放第index行的皇后位置
     *
     * @param n
     * @param index
     * @param row
     */
    private void putQueen(int n, int index, LinkedList<Integer> row) {

        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }

        for (int i = 0; i < n; i++) {

            /*
                主对角线行减去列的值都是相等的，但是为负数，数组索引都是大于0，索引需要加上n-1
                副对角线行加上列的值都是相等的

                如果当前列col[i]上没有其他皇后，且主副对角线上也没有其他皇后，则可以在该位置摆放皇后
             */
            if (!col[i] && !subDia[index + i] && !mainDia[index - i + n - 1]) {
                row.addLast(i);
                // 标记当前列已经有皇后占用
                col[i] = true;
                // 标记主副对角线已经有皇后占用
                subDia[index + i] = true;
                mainDia[index - i + n - 1] = true;

                // 摆放下一行
                putQueen(n, index + 1, row);

                col[i] = false;
                subDia[index + i] = false;
                mainDia[index - i + n - 1] = false;
                row.removeLast();
            }
        }
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row) {

        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 初始化每一行
            char[] charArray = new char[n];
            // 让charArray数组内容全部都为.
            Arrays.fill(charArray, '.');
            // 皇后位置为Q
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    private static void printBoard(List<String> board) {
        for (String s : board) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 4;
        List<List<String>> res = (new Solution1()).solveNQueens(n);
        for (List<String> board : res) {
            printBoard(board);
        }
    }
}
