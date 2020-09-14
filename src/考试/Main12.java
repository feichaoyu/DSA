package 考试;

import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 2
        int b = sc.nextInt(); // 4
        int c = sc.nextInt(); // 5
        int d = sc.nextInt(); // 15


        System.out.println(getCow(d));
    }

    private static int getCow(int n) {
        return getCow1(n) + getCow2(n) + getCow3(n) + getCow4(n);
    }

    private static int getCow1(int n) {
        if (n <= 1) {
            return 1;
        }
        return getCow1(n - 1) + getCow3(n - 1);
    }

    private static int getCow2(int n) {
        if (n <= 1) {
            return 0;
        }
        return getCow1(n - 1);
    }

    private static int getCow3(int n) {
        if (n <= 2) {
            return 0;
        }
        return getCow2(n - 1);
    }

    private static int getCow4(int n) {
        if (n <= 3) {
            return 0;
        }
        return getCow3(n - 1);
    }


}
