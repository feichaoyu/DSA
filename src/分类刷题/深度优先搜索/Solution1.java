package 分类刷题.深度优先搜索;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                sb.append(arr[i] + " ");
            } else {
                sb.append(arr[i]);
            }
        }
        System.out.println(sb.toString());
    }

    // 对arr[l...r]部分进行partition操作, 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(int[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, j + 1, i);
                j++;
            }
        }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(int[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
