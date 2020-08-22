package 剑指offer._53_03_IntegerIdenticalToIndex;

/**
 * @author feichaoyu
 */
public class Solution {

    public int findNumber(int[] nums) {

        int n = nums.length;
        int left = 0, right = n - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
