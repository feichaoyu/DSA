package 剑指offer._53_01_NumberOfK;

import java.util.HashMap;
import java.util.Map;

/**
 * 双指针
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left < nums.length && nums[left] != target) {
            left++;
        }
        while (right >= 0 && nums[right] != target) {
            right--;
        }
        return Math.max(right - left + 1, 0);
    }
}
