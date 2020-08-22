package 算法.排序算法.选择类排序.简单选择排序;

import 算法.排序算法.common.SortTestHelper;

/**
 * @author feichaoyu
 */
public class SelectionSort2 {

    // 在每一轮中, 可以同时找到当前未处理元素的最大值和最小值
    public static void sort(Comparable[] arr) {

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            if (arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                swap(arr, minIndex, maxIndex);
            }

            for (int i = left + 1; i < right; i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                } else if (arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("算法.排序算法.选择类排序.简单选择排序.SelectionSort2", arr);
    }
}
