package 算法.排序算法.归并排序;

import 算法.排序算法.common.SortTestHelper;
import 算法.排序算法.插入类排序.直接插入排序.InsertionSort;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class MergeSortBU {

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, Comparable[] aux, int l, int mid, int r) {

        System.arraycopy(arr, l, aux, l, r - l + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        Comparable[] aux = new Comparable[n];

        // Merge Sort Bottom Up 无优化版本
//        for (int len = 1; len < n; len += len) {
//            for (int i = 0; i < n - len; i += len + len) {
//                // 对 arr[i...i+len-1] 和 arr[i+len...i+2*len-1] 进行归并
//                // 需要满足 i+len < n 且 i+2*len-1 < n
//                merge(arr, aux, i, i + len - 1, Math.min(i + len + len - 1, n - 1));
//            }
//        }

        // 对于小数组, 使用插入排序优化
        for (int i = 0; i < n; i += 16) {
            InsertionSort.sort(arr, i, Math.min(i + 15, n - 1));
        }

        for (int len = 16; len < n; len += len) {
            for (int i = 0; i < n - len; i += len + len) {
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if (arr[i + len - 1].compareTo(arr[i + len]) > 0) {
                    merge(arr, aux, i, i + len - 1, Math.min(i + len + len - 1, n - 1));
                }
            }
        }

    }

    public static void main(String[] args) {

        // Merge Sort BU 也是一个O(nlogn)复杂度的算法，虽然只使用两重for循环
        // 所以，Merge Sort BU也可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易根据循环层数来判断算法的复杂度，Merge Sort BU就是一个反例
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("算法.排序算法.归并排序.MergeSortBU", arr);
    }
}
