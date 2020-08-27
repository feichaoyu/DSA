package 分类刷题.动态规划.最长上升子序列;

import java.util.Arrays;

/**
 * 定义状态：dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度
 * 状态转移：dp[i] = max{dp[j] + 1, dp[i]}, j从0到i
 */
public class Solution1 {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
