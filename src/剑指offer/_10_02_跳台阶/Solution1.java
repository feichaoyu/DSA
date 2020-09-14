package 剑指offer._10_02_跳台阶;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class Solution1 {

    private static int[] memo;

    public static int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calcWays(n);
    }

    private static int calcWays(int n) {
        // 就这里不同
        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = calcWays(n - 1) + calcWays(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(7));  // 21
    }
}
