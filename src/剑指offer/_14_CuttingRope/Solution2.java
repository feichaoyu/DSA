package 剑指offer._14_CuttingRope;

import java.util.Arrays;

/**
 * 动态规划
 * 定义状态：dp[i] 表示剪长度为 i 绳子的最大值
 * 状态转移：dp[i] = max(dp[i], (i - j) * j, j * dp[i - j])
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 *
 * @author feichaoyu
 */
public class Solution2 {

    // 提示：2 <= n <= 58
    public int cuttingRope(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 遍历不超过自己的数
            for (int j = 1; j <= i - 1; j++) {
                // 求以下三者众的最大值
                // 1.维持原状态，不剪
                // 2.从j处剪一下，剪下来的部分是i-j，i-j不再继续剪
                // 3.从j处剪一下，剪下李的部分是i-j，i-j继续剪
                dp[i] = max3(dp[i], j * (i - j), j * dp[i - j]);
            }
        }

        return dp[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).cuttingRope(2));
        System.out.println((new Solution2()).cuttingRope(10));
    }

}
