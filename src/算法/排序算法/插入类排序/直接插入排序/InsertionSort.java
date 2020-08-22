package 算法.排序算法.插入类排序.直接插入排序;

import 算法.排序算法.common.SortTestHelper;

/**
 * @author feichaoyu
 */
public class InsertionSort {

    // 对整个arr数组使用InsertionSort排序
    public static void sort(Comparable[] arr) {

        int n = arr.length;
        // 0位置不需要比，从1到最后一个位置n-1
        for (int i = 1; i <= n - 1; i++) {

            // 寻找元素arr[i]合适的插入位置

            // 写法1
//            for( int j = i ; j > 0 ; j -- )
//                if( arr[j].compareTo( arr[j-1] ) < 0 )
//                    swap( arr, j , j-1 );
//                else
//                    break;

            // 写法2
//            for( int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--) {
//                swap(arr, j, j-1);
//            }

            // 写法3
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;

        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > l && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int N = 10;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("算法.排序算法.插入类排序.直接插入排序.InsertionSort", arr);
        SortTestHelper.printArray(arr);
    }
}
