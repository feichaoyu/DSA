package 算法.背包问题._01背包;

import java.util.Arrays;

/**
 * 动态规划——优化背包1
 * 由于第i行元素只依赖于第i-1行元素。理论上，只需要保持两行元素。
 * 空间复杂度：O(2*C) = O(C)
 * 时间复杂度：O(n*C)
 *
 * @author feichaoyu
 */
public class Knapsack_DP_Optimize1 {

    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        if (n == 0) {
            return 0;
        }
        // 背包容量从0到C共 C+1个
        // 优化为2行
        memo = new int[2][C + 1];
        Arrays.fill(memo, -1);

        for (int j = 0; j <= C; j++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                // 1.不考虑编号为i的物品，直接看i-1的物品
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                // 2.考虑编号为i的物品
                if (j >= w[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }
            }
        }
        return memo[(n - 1) % 2][C];
    }

    public static void main(String[] args) {

    }
}
