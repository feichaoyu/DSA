package 剑指offer._10_01_斐波那契数列;

import java.util.Arrays;

/**
 * 记忆化搜索
 * 时间复杂度：O(n)
 * 空间福再度：O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    private static int[] memo;

    public static int fib(int n) {
        if (n < 0) {
            return 0;
        }

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return calcFib(n);
    }

    private static int calcFib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = calcFib(n - 1) + calcFib(n - 2);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(13));  // 233
    }
}
