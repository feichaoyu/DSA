package 输入输出;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
        }
        int res = 0;

        for (String name : names) {
            if (condition(name)) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean condition(String name) {
        return name.substring(0, 1).matches("[a-zA-Z+]") && name.length() <= 10;
    }

    private static boolean condition1(String name) {
        return name.substring(0, 1).matches("[a-zA-Z+]");
    }

    private static boolean condition2(String name) {
        return name.matches("^[a-z0-9A-Z]+$");
    }

    private static boolean condition3(String name) {
        return name.matches("^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]{6,20})$");
    }
}
