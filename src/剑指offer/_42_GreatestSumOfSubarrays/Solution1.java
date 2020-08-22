package 剑指offer._42_GreatestSumOfSubarrays;

/**
 * 分治算法（没有重叠子问题，无法使用记忆化搜索）
 * 分治法可行的关键的是：最大子序列和只可能出现在左子数组、右子数组或横跨左右子数组
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        return findMaxSubArray(nums, 0, nums.length - 1);
    }

    private int findMaxSubArray(int[] nums, int left, int right) {

        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        // 求解左子数组的最大值
        int leftSum = findMaxSubArray(nums, left, mid);
        // 求解右子数组的最大值
        int rightSum = findMaxSubArray(nums, mid + 1, right);
        // 求解横跨的左右数组之和的最大值
        int midSum = findMaxCrossingSubArray(nums, left, mid, right);

        return max3(leftSum, rightSum, midSum);
    }

    private int findMaxCrossingSubArray(int[] nums, int left, int mid, int right) {

        // 求解横跨左右的左子数组的最大值
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        // 求解横跨左右的右子数组的最大值
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
