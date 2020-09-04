package 输入输出;

import java.util.Scanner;

public class Baidu02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a1 = new int[0];
        int[] a2 = new int[0];
        for (int j = 0; j < m; j++) {
            int k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                a1 = new int[n];
                a1[i] = sc.nextInt();
                a2[i] = sc.nextInt();
            }
        }


    }
}
