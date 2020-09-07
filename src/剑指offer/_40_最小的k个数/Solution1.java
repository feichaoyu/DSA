package 剑指offer._40_最小的k个数;

import java.util.Arrays;

/**
 * 利用快速排序对一部分数据排序即可，不用对整个数组排序
 * 每次调用 partition 遍历的元素数目都是上一次遍历的 1/2，
 * 因此时间复杂度是 N + N/2 + N/4 + ... + N/N = 2N, 因此时间复杂度是 O(N)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] arr, int l, int r, int k) {

        // 以p为下标的所有左边元素小于arr[p]，右边元素大于arr[p]
        int p = partition(arr, l, r);
        if (p == k) {
            return Arrays.copyOf(arr, p + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段
        return p > k ? quickSearch(arr, l, p - 1, k) : quickSearch(arr, p + 1, r, k);
    }

    private int partition(int[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 不加等号如果遇到相等的情况，这时候while循环就会退出，即交换i和j的值，使得对于包含大量相同元素的数组，
            // 双方相等的数据就会交换，这样就可以一定程度保证两路的数据量平衡

            // 从i开始向后遍历，如果遍历的元素e<v，则继续向后遍历，直到遍历的元素e>=v，则停止遍历
            while (i <= r && arr[i] < v) {
                i++;
            }
            // 从j开始向前遍历，如果遍历的元素e>v，则继续向前遍历，直到遍历的元素e<=v，则停止遍历
            while (j >= l + 1 && arr[j] > v) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        // 此时j指向的元素是数组中最后一个小于v的元素, i指向的元素是数组中第一个大于v的元素
        swap(arr, l, j);

        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
