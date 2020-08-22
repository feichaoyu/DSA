package 算法.背包问题._01背包;

import java.util.Arrays;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Knapsack {
    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        // 背包容量从0到C共 C+1个
        memo = new int[n][C + 1];
        Arrays.fill(memo, -1);
        return bestValue(w, v, n - 1, C);
    }

    /**
     * 用 [0...index] 的物品，填充容量为c的背包的最大价值
     * 状态定义：F(n, C) 将n个物品放入容量为C的背包
     * 状态转移方程：F(i, c) = max{F(i-1, c), v(i)+F(i-1, c-w(i))}
     * F(i-1, c) 表示不计算当前物品，直接计算后面的物品
     * v(i)+F(i-1, c-w(i)) 表示计算当前物品，然后计算后面的物品
     *
     * @param w     weight 重量
     * @param v     value 价值
     * @param index 物品的索引
     * @param c     capacity 容量
     * @return
     */
    private int bestValue(int[] w, int[] v, int index, int c) {

        if (index < 0 || c <= 0) {
            return 0;
        }

        if (memo[index][c] != -1) {
            return memo[index][c];
        }

        int res = 0;
        if (c >= w[index]) {
            res = Math.max(bestValue(w, v, index - 1, c),
                    v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }

    public static void main(String[] args) {

    }
}
