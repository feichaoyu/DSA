package 分类刷题.深度优先搜索;

import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int n = in.nextInt();
        n = n % s.length();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        System.out.println(sb.substring(n));
    }
}
