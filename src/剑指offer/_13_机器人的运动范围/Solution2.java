package 剑指offer._13_机器人的运动范围;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 广度优先遍历
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int movingCount(int m, int n, int k) {

        int[][] d = {{1, 0}, {0, 1}};
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            if (inArea(position[0], position[1], m, n) &&
                    !visited[position[0]][position[1]] &&
                    (position[0] / 10 + position[0] % 10 + position[1] / 10 + position[1] % 10) <= k) {
                visited[position[0]][position[1]] = true;
                count++;
                // 继续找下方和右方的
                for (int i = 0; i < 2; i++) {
                    queue.add(new int[]{position[0] + d[i][0], position[1] + d[i][1]});
                }
            }
        }
        return count;
    }

    private boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().movingCount(2, 3, 1));  // 3
        System.out.println(new Solution2().movingCount(3, 1, 0));  // 1
    }
}
