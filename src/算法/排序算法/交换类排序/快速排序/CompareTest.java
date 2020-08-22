package 算法.排序算法.交换类排序.快速排序;

import 算法.排序算法.common.SortTestHelper;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class CompareTest {
    // 比较Merge Sort和Quick Sort两种排序算法的性能效率
    // 两种排序算法虽然都是O(nlogn)级别的, 但是Quick Sort算法有常数级的优势
    // Quick Sort要比Merge Sort快, 即使我们对Merge Sort进行了优化
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort", arr1);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort", arr2);

        System.out.println();

        // 测试2 测试近乎有序的数组
        // 但是对于近乎有序的数组, 我们的快速排序算法退化成了O(n^2)级别的算法
        // 思考一下为什么对于近乎有序的数组, 快排退化成了O(n^2)的算法?
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort", arr1);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort", arr2);

        // 测试3 测试存在包含大量相同元素的数组
        // 使用双快速排序后, 我们的快速排序算法可以轻松的处理包含大量元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort", arr1);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort2Ways", arr2);
    }
}
