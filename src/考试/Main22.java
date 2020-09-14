package 考试;

import java.util.Scanner;

public class Main22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (n == 1) {
            System.out.println(m);
            return;
        }

        int left = 1, right = m;
        while (left < right) {
            int mid = (right + left) / 2;
            if (sum(mid, n) == m) {
                System.out.println(mid);
                return;
            } else if (sum(mid, n) < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }

    // 计算如果第一天吃 x 块巧克力总共需要多少块巧克力
    private static int sum(int x, int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += x;
            // 不少于前一天的一半,需要向上取整
            x = (x + 1) / 2;
        }
        return sum;
    }
}
