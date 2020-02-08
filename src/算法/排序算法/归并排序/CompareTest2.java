package 算法.排序算法.归并排序;

import 算法.排序算法.common.SortTestHelper;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class CompareTest2 {
    // 比较 MergeSort2 和 MergeSort3 的性能效率
    // MergeSort3 只开辟了一次辅助空间, 之后将这个辅助空间以参数形式传递给完成归并排序的其他子函数
    // 可以看出 MergeSort3 的性能优于 MergeSort2
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort2", arr1);
        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort3", arr2);

        System.out.println();

        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort2", arr1);
        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort3", arr2);
    }
}
