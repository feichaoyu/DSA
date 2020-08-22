package 算法.背包问题._01背包;

import java.util.Arrays;

/**
 * 动态规划——优化背包2
 * 只用一行
 *
 * @author feichaoyu
 */
public class Knapsack_DP_Optimize2 {

    private int[] memo;

    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        if (n == 0) {
            return 0;
        }
        // 背包容量从0到C共 C+1个
        // 优化为一位数组即只有一行
        memo = new int[C + 1];
        Arrays.fill(memo, -1);

        for (int j = 0; j <= C; j++) {
            memo[j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }
        return memo[C];
    }

    public static void main(String[] args) {

    }
}
