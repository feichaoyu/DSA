package 剑指offer._53_01_NumberOfK;

/**
 * 二分搜索
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int search(int[] nums, int target) {

        // 搜索右边界right
        int left, right;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            // 目标元素在右半部分
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        // 记录右边界
        right = i;
        // 若数组中无target，则提前返回
        if (j >= 0 && nums[j] != target) {
            return 0;
        }

        // 搜索左边界left
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        // 记录左边界
        left = j;

        /*
        形如：
           left       right   => right-left-1=3
        2   3   5 5 5   7
         */
        return right - left - 1;
    }
}
