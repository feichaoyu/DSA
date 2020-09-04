package 分类刷题.堆.数组中的第K个最大元素;

/**
 * 快排思想
 */
public class Solution1 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 第k大元素的索引是len-k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            swap(nums, left, (int) (Math.random() * (right - left + 1)) + left);
        }

        int v = nums[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && nums[i] < v) {
                i++;
            }
            while (i <= j && nums[j] > v) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
