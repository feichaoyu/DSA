package 考试;

import java.util.Scanner;

public class Main15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long i = 1;
        while (true) {
            i++;
            if (isContainsTarget(i)) {
                n--;
            }
            if (n == 0) {
                break;
            }
        }

        System.out.println(i);
    }

    private static boolean isContainsTarget(long num) {
        String s = String.valueOf(num);
        if (match(s)) {
            return true;
        }
        return false;
    }

    private static boolean match(String s) {
        return s.matches("[235]*");
    }
}
