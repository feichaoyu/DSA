package 剑指offer._03_01_DuplicationInArray;

import java.util.Arrays;

/**
 * 利用排序，排序后遍历一次（快排）
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author feichaoyu
 */
public class Solution2 {

    public static int getDuplication(int[] data) {

        // 输入空指针
        if (data == null || data.length < 2) {
            return -1;
        }

        // 输入数据范围无效
        for (int datum : data) {
            if (datum < 0 || datum > data.length - 1) {
                return -1;
            }
        }
//        Arrays.sort(data); // 或者使用内置函数进行排序
        quickSort(data, 0, data.length - 1);
        if (data.length < 2) {
            return -1;
        }

        // prev指向数组第一个元素
        int prev = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] == prev) {
                return prev;
            } else {
                // 不相等则指向后一个元素
                prev = data[i];
            }
        }
        return -1;
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int bound = partion(data, start, end);
        quickSort(data, start, bound - 1);
        quickSort(data, bound + 1, end);
    }

    private static int partion(int[] data, int start, int end) {
        if (start >= end) {
            return end;
        }
        int pivot = data[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && data[right] >= pivot) {
                right--;
            }
            if (left < right) {
                data[left++] = data[right];
            }
            while (left < right && data[left] < pivot) {
                left++;
            }
            if (left < right) {
                data[right--] = data[left];
            }
        }
        data[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("操作前数组" + Arrays.toString(data));
        System.out.println(getDuplication(data));
        System.out.println("操作后数组" + Arrays.toString(data));

        int[] data2 = {2, 3, 1, 0, 6, 5, 4};
        System.out.println(getDuplication(data2));
    }

}
