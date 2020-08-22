package 算法.背包问题.完全背包;

import java.util.Scanner;

/**
 * @author feichaoyu
 */
public class Solution {

    // 完全背包
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 背包容量（总钱数）
        int target = in.nextInt();
        // 物品种类个数
        int n = in.nextInt();

        // 价格
        int[] weight = new int[n];
        // 使用价值
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }

        int j = 0;
        int[] arr = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (j = weight[i]; j <= target; j++) {
                arr[j] = Math.max(arr[j], arr[j - weight[i]] + value[i]);
            }
        }
        System.out.println(arr[j - 1]);

    }

    // 多重背包
    public static void multipleBag() {
        Scanner in = new Scanner(System.in);
        // 背包容量（总钱数）
        int target = in.nextInt();
        // 物品种类个数
        int n = in.nextInt();

        // 价格
        int[] weight = new int[n];
        // 使用价值
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
            value[i] = in.nextInt();
        }

        int j = 0;
        int[] arr = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (j = weight[i]; j <= target; j++) {
                arr[j] = Math.max(arr[j], arr[j - weight[i]] + value[i]);
            }
        }
        System.out.println(arr[j - 1]);

    }
}
