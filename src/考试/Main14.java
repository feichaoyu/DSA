package 考试;

import java.util.Scanner;

public class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2 * n - 1];
            int mid = (2 * n - 1) / 2;
            for (int i = 0; i < n; i++) {
                for (int j = mid - i; j <= mid + i; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] dp = new int[n][arr[0].length];
            dp[0][mid] = arr[0][mid];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    int temp = 0;
                    if (j == 0) {
                        temp = Math.max(dp[i - 1][j], dp[i - 1][j + 1]);
                    } else if (j == arr[0].length - 1) {
                        temp = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    } else {
                        temp = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                        temp = Math.max(temp, dp[i - 1][j + 1]);
                    }
                    dp[i][j] = Math.max(dp[i][j], temp + arr[i][j]);
                }
            }
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < arr[0].length; i++) {
                res = Math.max(res, dp[n - 1][i]);
            }
            System.out.println(res);
        }
    }
}
