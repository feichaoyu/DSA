package 剑指offer._21_02_ReorderArray;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class Solution {

    public int[] exchange(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            // 如果指针i对应的元素是偶数，那么就需要找到其后出现的第一个奇数，然后和指针i的元素进行交换
            if (isEven(nums[i])) {
                int j = i + 1;
                while (j < nums.length && isEven(nums[j])) {
                    j++;
                }

                if (j == nums.length) {
                    break;
                } else {
                    // 整体右移，保证原元素的相对位置不变
                    int temp = nums[j];
                    for (int k = j; k > i; k--) {
                        nums[k] = nums[k - 1];
                    }
                    nums[i] = temp;
                }
            }
            i++;
        }
        return nums;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().exchange(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }
}
