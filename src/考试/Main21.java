package 考试;

import java.util.Scanner;

public class Main21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int target = sc.nextInt();
        String[] s = input.split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int left = 0;
        int right = arr.length - 1;

        if (target < arr[left]) {
            System.out.println(0);
            return;
        }
        if (target > arr[right]) {
            System.out.println(arr.length);
            return;
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                System.out.println(mid);
                return;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (arr[mid] < target && arr[mid + 1] > target) {
                System.out.println(mid + 1);
                return;
            }
        }
    }
}
