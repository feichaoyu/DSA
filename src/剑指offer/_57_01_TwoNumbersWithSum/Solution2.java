package 剑指offer._57_01_TwoNumbersWithSum;

/**
 * 由于是排序的，使用双指针
 * 时间复杂度O(1)
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }
}
