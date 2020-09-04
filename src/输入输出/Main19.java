package 输入输出;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main19 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 7, 6, 5, 5, 3, 4, 2, 0, 0, 3, 5, 2, 4, 2, 4, 8};
        List<int[]> res = new ArrayList<>();
        int left = 0, right = 1;
        while (right < arr.length) {
            while (right < arr.length && arr[right] > arr[right - 1]) {
                right++;
            }
            int[] up = new int[right - left];
            if (up.length >= 3) {
                System.arraycopy(arr, left, up, 0, right - left);
                res.add(up);
            }

            left = right;
            right = left + 1;
        }

        for (int[] ans : res) {
            System.out.println(Arrays.toString(ans));
        }
    }
}
