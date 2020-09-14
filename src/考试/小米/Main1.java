package 考试.小米;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] passwords = input.split(" ");
        for (String password : passwords) {
            System.out.println(isValid(password));
        }
    }

    private static int isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length >= 8 && chars.length <= 120) {
            int[] res = new int[4];
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 'a' && chars[i] <= 'z') {
                    res[0]++;
                } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    res[1]++;
                } else if (chars[i] >= '0' && chars[i] <= '9') {
                    res[2]++;
                } else {
                    res[3]++;
                }
            }
            for (int i = 0; i < res.length; i++) {
                if (res[i] == 0) {
                    return 2;
                }
            }
            return 0;
        } else {
            return 1;
        }
    }
}
