package 分类刷题.动态规划.最长上升子序列;

import java.util.Arrays;

/**
 * 记忆化搜索
 */
public class Solution2 {

    /**
     * memo[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
     */
    private int[] memo;

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, getMaxLength(nums, i));
        }

        return res;
    }

    private int getMaxLength(int[] nums, int index) {

        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 1;
        for (int i = 0; i <= index - 1; i++) {
            if (nums[index] > nums[i]) {
                res = Math.max(res, 1 + getMaxLength(nums, i));
            }
        }

        memo[index] = res;
        return memo[index];
    }
}
