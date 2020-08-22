package 分类刷题.深度优先搜索;

import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int col = max(arr[i], -1);
            for (int j = i + 1; j < n; j++) {
                int val = arr[i][col] * arr[j][max(arr[j], col)];
                if (res < val) {
                    res = val;
                }
            }
        }
        System.out.println(res);
    }

    private static int max(int[] num, int col) {
        int j = 0;
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            if (col == i) {
                continue;
            }
            if (result < num[i]) {
                result = num[i];
                j = i;
            }
        }
        return j;
    }
}
