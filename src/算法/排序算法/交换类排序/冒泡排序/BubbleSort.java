package 算法.排序算法.交换类排序.冒泡排序;

/**
 * @author feichaoyu
 */
public class BubbleSort {

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = n; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
