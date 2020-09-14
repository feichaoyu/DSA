package 考试;

import java.util.Scanner;

public class Main7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for (int k = 5; k <= n; k = k * 5) {
            count = count + n / k;
        }
        System.out.println(count);
    }
}
