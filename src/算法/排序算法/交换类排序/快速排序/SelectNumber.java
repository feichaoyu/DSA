package 算法.排序算法.交换类排序.快速排序;

import 算法.排序算法.common.SortTestHelper;

/**
 * 查找数组中第 n 大的元素
 *
 * @author feichaoyu
 */
public class SelectNumber {

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    // partition 过程, 和快排的partition一样
    // 思考: 双路快排和三路快排的思想能不能用在selection算法中?
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }

        swap(arr, l, j);

        return j;
    }

    // 求出nums[l...r]范围里第k小的数
    private static Comparable solve(Comparable[] nums, int l, int r, int k) {

        if (l == r) {
            return nums[l];
        }

        // partition之后, nums[p]的正确位置就在索引p上
        int p = partition(nums, l, r);

        // 如果 k == p, 直接返回nums[p]
        if (k == p) {
            return nums[p];
        }
        // 如果 k < p, 只需要在nums[l...p-1]中找第k小元素即可
        else if (k < p) {
            return solve(nums, l, p - 1, k);
        }
        // 如果 k > p, 则需要在nums[p+1...r]中找第k-p-1小元素
        // 注意: 由于我们传入的依然是nums, 而不是nums[p+1...r],
        // 所以传入的最后一个参数依然是k, 而不是k-p-1
        else {
            return solve(nums, p + 1, r, k);
        }
    }

    // 寻找nums数组中第k小的元素
    // 注意: 在我们的算法中, k是从0开始索引的, 即最小的元素是第0小元素, 以此类推
    // 如果希望我们的算法中k的语意是从1开始的, 只需要在整个逻辑开始进行k--即可, 可以参考solve2
    public static Comparable solve(Comparable nums[], int k) {

        assert nums != null && k >= 0 && k < nums.length;
        return solve(nums, 0, nums.length - 1, k);
    }

    // 寻找nums数组中第k小的元素, k从1开始索引, 即最小元素是第1小元素, 以此类推
    public static Comparable solve2(Comparable nums[], int k) {

        return SelectNumber.solve(nums, k - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        // 生成一个大小为n, 包含0...n-1这n个元素的随机数组arr
        int N = 10000;
        Integer[] arr = SortTestHelper.generateOrderedArray(N);
        SortTestHelper.shuffleArray(arr);

        // 验证Selection.solve, 对arr数组求第i小元素, 应该为i
        for (int i = 0; i < N; i++) {
            assert solve(arr, i).equals(i);
            System.out.println("test " + i + " complete.");
        }
        System.out.println("Test Selection.solve completed.");
        System.out.println();

        arr = SortTestHelper.generateOrderedArray(N);
        SortTestHelper.shuffleArray(arr);

        // 验证Selection.solve2, 对arr数组求第i小元素, 应该为i-1
        // 因为在Selection.solve2中, 第k小元素的k是从1索引的
        for (int i = 1; i < N; i++) {
            assert solve2(arr, i).equals(i - 1);
            System.out.println("test " + i + " complete.");
        }
        System.out.println("Test Selection.solve2 completed.");

    }
}
