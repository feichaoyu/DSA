package 考试.小米;

import java.util.Scanner;

public class Main2 {

    /**
     * 方向
     */
    private static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * 二维网格board的行和列
     */
    private static int row, column;

    /**
     * 是否已经被访问过
     */
    private static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {

        if (board == null || word == null || board.length == 0 || word.length() == 0) {
            return false;
        }

        row = board.length;
        column = board[0].length;
        // 默认为false
        visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord(char[][] board, String word, int index,
                                      int startX, int startY) {

        // 已经遍历到单词的末尾
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            // 标记该位置已经使用过
            visited[startX][startY] = true;
            // 遍历上下左右四个方向
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                // 在区域内，且之前没有访问过的前提下，如果searchWord返回true，则找到
                if (inArea(newX, newY) && !visited[newX][newY] &&
                        searchWord(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            // 上下左右四个方向都没有找到，放弃该位置
            visited[startX][startY] = false;
        }
        return false;
    }

    private static boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        char[][] data = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        System.out.println(exist(data, word));
    }

}
