package 算法.排序算法.交换类排序.冒泡排序;

/**
 * @author feichaoyu
 */
public class BubbleSort3 {

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        int newn;

        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                    // 记录最后一次的交换位置，在此之后的元素都是已经有序的，因此下一轮扫描中不再考虑
                    newn = i;
                }
            }
            n = newn;
        } while (newn > 0);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
