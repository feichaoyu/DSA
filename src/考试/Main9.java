package 考试;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && s.charAt(i) == 'n') {
                String substring = s.substring(j, i);
                StringBuffer sb = new StringBuffer();
                sb.append(substring.substring(0, 1).toUpperCase()).append(substring.substring(1));
                System.out.println(sb);
                j = i;
            }
        }
        if (j != s.length() - 1) {
            String substring = s.substring(j);
            StringBuffer sb = new StringBuffer();
            sb.append(substring.substring(0, 1).toUpperCase()).append(substring.substring(1));
            System.out.println(sb);
        }
    }
}
