package 输入输出;

import java.util.Scanner;

public class Main16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = a[0];
        int res = dp[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] + a[i] > a[i] && a[i] != 0) {
                dp[i] = dp[i - 1] + a[i];
                count++;
            } else if (dp[i - 1] + a[i] > a[i] && a[i] == 0) {
                dp[i] = dp[i - 1] + a[i];
            } else {
                dp[i] = a[i];
                count = 1;
            }

            res = Math.max(res, dp[i]);
        }

        System.out.println(res * res + " " + count);

    }
}
