package 算法.排序算法.选择类排序.堆排序;

import 算法.排序算法.common.SortTestHelper;

/**
 * @author feichaoyu
 */
public class HeapSort3 {
    // 我们的算法类不允许产生任何实例
    private HeapSort3() {
    }

    // 不使用一个额外的最大堆, 直接在原数组上进行 原地堆排序
    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // heapify
        // 注意，此时我们的堆是从0开始索引的，参考MaxHeap的实现
        for (int i = parent(n-1); i >= 0; i--) {
            siftDown2(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown2(arr, i, 0);
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 原始的siftDown过程
    private static void siftDown(Comparable[] arr, int n, int k) {

        while (leftChild(k) < n) {
            int j = leftChild(k);
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j = rightChild(k);
            }

            // 如果父节点比左右孩子中的最大值还要大，那么说明没有问题，直接退出
            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }

            // 否则交换
            swap(arr, k, j);
            k = j;
        }
    }

    // 优化的siftDown过程, 使用赋值的方式取代不断的swap,
    // 该优化思想和我们之前对插入排序进行优化的思路是一致的
    private static void siftDown2(Comparable[] arr, int n, int k) {

        Comparable e = arr[k];
        while (leftChild(k) < n) {
            int j = leftChild(k);
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                j = rightChild(k);
            }

            if (e.compareTo(arr[j]) >= 0) {
                break;
            }

            arr[k] = arr[j];
            k = j;
        }

        arr[k] = e;
    }

    private static int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private static int leftChild(int index) {
        return index * 2 + 1;
    }

    private static int rightChild(int index) {
        return index * 2 + 2;
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort3", arr);
    }
}
