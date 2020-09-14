package 考试.网易;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int res = 0;
        int status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'b') {
                status ^= (1 << 1);
            } else if (ch == 'c') {
                status ^= (1 << 2);
            } else if (ch == 'x') {
                status ^= (1 << 3);
            } else if (ch == 'y') {
                status ^= (1 << 4);
            } else if (ch == 'z') {
                status ^= (1 << 5);
            }

            if (pos[status] >= 0) {
                res = Math.max(res, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        System.out.println(res);
    }
}
