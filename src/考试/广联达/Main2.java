package 考试.广联达;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    private static int[] dp;

    public static int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        if (n == 0) {
            return 0;
        }
        // 背包容量从0到C共 C+1个
        // 优化为一位数组即只有一行
        dp = new int[C + 1];
        Arrays.fill(dp, -1);

        for (int j = 0; j <= C; j++) {
            dp[j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 物品种类个数
        int n = in.nextInt();
        // 背包容量
        int target = in.nextInt();
        // 电量
        int[] weight = new int[n];
        // 愉悦度
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = (int) in.nextFloat();
            value[i] = in.nextInt();
        }

        System.out.println(knapsack01(weight, value, target));
    }
}
