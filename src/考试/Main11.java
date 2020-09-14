package 考试;

import java.util.Scanner;

public class Main11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String string = input.replace("[", "").replace("]", "");
        String[] chars = string.split(",");
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = Integer.parseInt(chars[i]);
        }
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}
