package 考试;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] steps = new int[m];
        int[] nums = new int[n];

        for (int i = 0; i < m; i++) {
            steps[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        for (int i = 0; i < m; i++) {
            if (steps[i] == 1) {
                int temp = nums[0];
                int j;
                for (j = 0; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[j] = temp;
            } else {
                for (int j = 0; j < n - 1; j = j + 2) {
                    swap(nums, j, j + 1);
                }
            }
        }
        print(nums);
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
