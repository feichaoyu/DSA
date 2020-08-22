package 剑指offer._13_RobotMove;

/**
 * DFS 深度优先遍历
 *
 * @author feichaoyu
 */
public class Solution1 {

    /**
     * 方向
     */
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * 是否已经被访问过
     */
    private boolean[][] visited;

    private int count = 0;

    public int movingCount(int m, int n, int k) {

        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }

        visited = new boolean[m][n];
        dfs(0, 0, m, n, k);
        return count;
    }

    private void dfs(int startX, int startY, int m, int n, int k) {

        if (visited[startX][startY]) {
            return;
        }

        // 标记该位置已经使用过
        visited[startX][startY] = true;

        // 获取数位和
        int sum = getDigitSum(startX) + getDigitSum(startY);
        if (sum <= k) {
            count++;
        } else {
            // 一旦发现和大于k了，那么后面就不可达了，即使有解
            return;
        }

        // 遍历上下左右四个方向
        for (int i = 0; i < 4; i++) {
            int newX = startX + d[i][0];
            int newY = startY + d[i][1];
            if (inArea(newX, newY, m, n)) {
                dfs(newX, newY, m, n, k);
            }
        }
    }

    public int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().movingCount(2, 3, 1));  // 3
        System.out.println(new Solution1().movingCount(3, 1, 0));  // 1
    }
}
