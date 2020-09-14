package 考试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baidu01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // v0 记录卡片0的数量，v5 记录卡片5的数量
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v5 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                v0.add(num);
            } else {
                v5.add(num);
            }
        }

        // 如果v0=0，则直接输出-1，因为要被90整除必须最后一位是0
        if (v0.size() == 0) {
            System.out.println(-1);
            return;
        }

        // 如果v0>0 && v5<9 ，则输出0
        if (v0.size() > 0 && v5.size() < 9) {
            System.out.println(0);
            return;
        }

        // 否则，循环 v5 次打印5，然后循环 v0 次打印0
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v5.size(); i++) {
            sb.append("5");
        }

        for (int i = 0; i < v0.size(); i++) {
            sb.append("0");
        }

        System.out.println(sb);

    }
}
