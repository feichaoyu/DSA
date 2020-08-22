package 算法.排序算法.选择类排序.堆排序;

import 算法.排序算法.common.SortTestHelper;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class CompareTest {
    // 比较 Merge Sort, 三种 Quick Sort 和三种 Heap Sort 的性能效率
    // 注意, 这几种排序算法都是 O(nlogn) 级别的排序算法
    public static void main(String[] args) {

        int N = 1000000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort", arr1);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort", arr2);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort2Ways", arr3);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort3Ways", arr4);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort", arr5);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort2", arr6);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort3", arr7);

        System.out.println();

        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort", arr1);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort", arr2);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort2Ways", arr3);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort3Ways", arr4);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort", arr5);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort2", arr6);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort3", arr7);

        System.out.println();

        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSort", arr1);
        // 这种情况下, 普通的QuickSort退化为O(n^2)的算法, 不做测试
        //SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort", arr2);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort2Ways", arr3);
        SortTestHelper.testSort("算法.排序算法.交换类排序.快速排序.QuickSort3Ways", arr4);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort", arr5);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort2", arr6);
        SortTestHelper.testSort("算法.排序算法.选择类排序.堆排序.HeapSort3", arr7);
    }
}
