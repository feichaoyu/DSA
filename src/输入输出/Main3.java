package 输入输出;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        int[] arr = new int[n];

        // 物品的重量
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        // 获取的排列
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            w[arr[i] - 1] = -1;
            max(w);
        }
        System.out.println(0);
    }

    private static void max(int[] w) {
        int res = 0;
        for (int i = 0; i < w.length; i++) {
            if (w[i] != -1) {
                int sum = 0;
                while (i < w.length && w[i] != -1) {
                    sum += w[i++];
                }
                if (sum > res) {
                    res = sum;
                }
            }
        }
        System.out.println(res);
    }
}
