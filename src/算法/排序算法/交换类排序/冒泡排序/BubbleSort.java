package 算法.排序算法.交换类排序.冒泡排序;

/**
 * @author feichaoyu
 */
public class BubbleSort {
    // 我们的算法类不允许产生任何实例
    private BubbleSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        boolean swapped = false;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                    swapped = true;
                }
            }

            // 每一次for循环将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑，n--
            n--;
        } while (swapped);  // 只要有交换，就说明还没有排序完，除非swapped为false，说明不再发生交换，即排序完了，不需要再进行多余的比较了
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
