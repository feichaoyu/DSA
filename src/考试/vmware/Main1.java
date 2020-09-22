package 考试.vmware;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double m = sc.nextDouble();
        double r = sc.nextDouble();


        double cnt = r;
        // 统计次数
        int count = 0;
        double j = 0.00;
        while (true) {
            while (j < n) {
                if (cnt <= n) {
                    System.out.println(new BigDecimal(cnt).setScale(2, BigDecimal.ROUND_UP).toString() + " " + "0.00");
                    cnt += r;
                    count++;
                } else {
                    break;
                }
            }

            if (count >= m) {
                break;
            }

            while (j < 2 * n) {
                if (cnt <= 2 * n) {
                    System.out.println(new BigDecimal(n).setScale(2, BigDecimal.ROUND_UP).toString() + " " + new BigDecimal(cnt - n).setScale(2, BigDecimal.ROUND_UP).toString());
                    cnt += r;
                    count++;
                } else {
                    break;
                }
            }

            if (count >= m) {
                break;
            }

            while (j < 3 * n) {
                if (cnt <= 3 * n) {
                    System.out.println(new BigDecimal(3 * n - cnt).setScale(2, BigDecimal.ROUND_UP).toString() + " " + new BigDecimal(n).setScale(2, BigDecimal.ROUND_UP).toString());
                    cnt += r;
                    count++;
                } else {
                    break;
                }
            }

            if (count >= m) {
                break;
            }

            while (j < 4 * n) {
                if (cnt <= 4 * n) {
                    System.out.println("0.00" + " " + new BigDecimal(4 * n - cnt).setScale(2, BigDecimal.ROUND_UP).toString());
                    cnt += r;
                    count++;
                } else {
                    break;
                }
            }

            if (count >= m) {
                break;
            }

            cnt %= 4 * n;
        }
    }
}
