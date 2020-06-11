package 剑指offer._49_UglyNumber;

/**
 * 动态规划
 * 定义状态：dp[i]表示第i+1个丑数
 * 状态转移：dp[i] = min{ dp[p2] * 2, dp[p3] * 3, dp[p5] * 5 }
 * 思路：https://leetcode-cn.com/problems/chou-shu-lcof/solution/chou-shu-ii-qing-xi-de-tui-dao-si-lu-by-mrsate/
 *
 * @author feichaoyu
 */
public class Solution {

    public int nthUglyNumber(int n) {

        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = min3(dp[p2] * 2, dp[p3] * 3, dp[p5] * 5);
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }

    private int min3(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
