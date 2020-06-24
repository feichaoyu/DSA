package 剑指offer._51_InversePairs;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class Solution {

    public int reversePairs(int[] nums) {

        int n = nums.length;
        return reversePairs(nums, 0, n - 1);
    }

    // 求arr[l..r]范围的逆序数对个数
    private int reversePairs(int[] arr, int l, int r) {

        if (l >= r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        // 左边区间的逆序对
        int leftPairs = reversePairs(arr, l, mid);
        // 右边区间的逆序对
        int rightPairs = reversePairs(arr, mid + 1, r);
        // 横跨两个区间的逆序对
        int crossPairs = merge(arr, l, mid, r);

        return leftPairs + rightPairs + crossPairs;
    }

    private static int merge(int[] arr, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化逆序数对个数 res = 0
        int res = 0;
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] <= (aux[j - l])) {  // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {   // 右半部分所指元素 < 左半部分所指元素
                arr[k] = aux[j - l];
                j++;
                // 此时, 因为右半部分k所指的元素小
                // 这个元素和左半部分的所有未处理的元素都构成了逆序数对
                // 左半部分此时未处理的元素个数为 mid - i + 1
                res += mid - i + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 6, 4};
        System.out.println(new Solution().reversePairs(nums));
    }
}
