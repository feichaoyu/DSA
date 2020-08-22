package 算法.排序算法.插入类排序.希尔排序;

import 算法.排序算法.common.SortTestHelper;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class CompareTest {
    // 比较SelectionSort, InsertionSort和BubbleSort和ShellSort四种排序算法的性能效率
    // ShellSort是这四种排序算法中性能最优的排序算法
    public static void main(String[] args) {

        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.选择类排序.简单选择排序.SelectionSort", arr1);
        SortTestHelper.testSort("算法.排序算法.插入类排序.直接插入排序.InsertionSort", arr2);
        SortTestHelper.testSort("算法.排序算法.交换类排序.冒泡排序.BubbleSort3", arr3);
        SortTestHelper.testSort("算法.排序算法.插入类排序.希尔排序.ShellSort", arr4);

        System.out.println();

        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("算法.排序算法.选择类排序.简单选择排序.SelectionSort", arr1);
        SortTestHelper.testSort("算法.排序算法.插入类排序.直接插入排序.InsertionSort", arr2);
        SortTestHelper.testSort("算法.排序算法.交换类排序.冒泡排序.BubbleSort3", arr3);
        SortTestHelper.testSort("算法.排序算法.插入类排序.希尔排序.ShellSort", arr4);
    }
}
