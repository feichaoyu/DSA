package 剑指offer._14_CuttingRope;

import java.util.Arrays;

/**
 * 记忆化搜索
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    private int[] memo;

    // 提示：2 <= n <= 58
    public int cuttingRope(int n) {

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return ropeCutting(n);
    }

    private int ropeCutting(int n) {

        if (n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            // 求【之前结果、不对n-i再次分割、对n-i再次分割】三者中最大值
            res = max3(res, i * (n - i), i * ropeCutting(n - i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).cuttingRope(2));
        System.out.println((new Solution1()).cuttingRope(10));
    }
}
