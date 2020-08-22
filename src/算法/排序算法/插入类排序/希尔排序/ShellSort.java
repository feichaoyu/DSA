package 算法.排序算法.插入类排序.希尔排序;

/**
 * @author feichaoyu
 */
public class ShellSort {

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        // 步长序列: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            for (int i = h; i < n; i++) {
                // 将 arr[i] 插入到 arr[i-h], arr[i-2*h], arr[i-3*h]... 中
                Comparable e = arr[i];
                int j;
                // 优化的插入排序
                for (j = i; j >= h && e.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }
            h /= 3;
        }
    }
}
