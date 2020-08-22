package 剑指offer._42_GreatestSumOfSubarrays;

/**
 * 动态规划
 * 定义状态：dp[i] 表示以元素 nums[i] 结尾的连续子数组最大和
 * 状态转移：dp[i] = max{dp[i-1] + nums[i], nums[i]}
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
