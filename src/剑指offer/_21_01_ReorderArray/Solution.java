package 剑指offer._21_01_ReorderArray;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class Solution {

    public int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 左边是奇数，右边是偶数，不交换，左边进一位并且右边退一位
            if (isOdd(nums[left]) && !isOdd(nums[right])) {
                left++;
                right--;
            }
            // 左边是奇数，右边也是奇数，不交换，左边进一位
            else if (isOdd(nums[left]) && isOdd(nums[right])) {
                left++;
            }
            // 左边是偶数，右边是奇数，交换，然后左边进一位并且右边退一位
            else if (!isOdd(nums[left]) && isOdd(nums[right])) {
                swap(nums, left, right);
                left++;
                right--;
            }
            // 左边是偶数，右边也是偶数，不交换，右边退一位
            else {
                right--;
            }
        }
        return nums;
    }

    private boolean isOdd(int number) {
        return number % 2 == 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{1, 2, 3, 4, 5})));
    }
}
