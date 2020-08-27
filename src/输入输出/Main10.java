package 输入输出;

import java.util.Arrays;
import java.util.Scanner;

public class Main10 {

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

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        // rongl
        int n = sc.nextInt();

        for (int i = 0; i < m; i++) {

        }

    }
}
