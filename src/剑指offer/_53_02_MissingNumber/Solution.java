package 剑指offer._53_02_MissingNumber;

/**
 * @author feichaoyu
 */
public class Solution {

    public int missingNumber(int[] nums) {

        int n = nums.length;
        int left = 0, right = n - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 不相等向左找
            if (nums[mid] != mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
