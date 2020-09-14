package 考试.广联达;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 小草个数
        int n = sc.nextInt();
        // 魔法药剂的个数
        int m = sc.nextInt();
        // 长高的高度
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            sort(arr);
            arr[0] = arr[0] + x;
        }
        sort(arr);

        System.out.println(arr[0]);
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        for (int i = 1; i <= n - 1; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;

        }
    }
}
