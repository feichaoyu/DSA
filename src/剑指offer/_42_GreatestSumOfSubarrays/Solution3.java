package 剑指offer._42_GreatestSumOfSubarrays;

/**
 * 空间优化的动态规划
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author feichaoyu
 */
public class Solution3 {

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int dp = nums[0];
        int res = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(res, dp);
        }
        return res;
    }
}
