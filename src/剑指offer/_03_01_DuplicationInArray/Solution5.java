package 剑指offer._03_01_DuplicationInArray;

import java.util.Arrays;

/**
 * 根据数字特点排序
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author feichaoyu
 */
public class Solution5 {

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

        for (int i = 0; i < data.length; i++) {
            // 当扫描到下标为 i 的数字时，首先比较这个数字 m 是否等于 i
            // 如果是，则接着扫描下一个数字
            if (data[i] == i) {
                continue;
            }

            do {
                // 如果不是，则将第 i 个数字 和第 m 个数字比较，相等则表示找到一个重复数字
                if (data[i] == data[data[i]]) {
                    return data[i];
                }
                // 不相等就把第 i 个数字和第 m 个数字交换
                swap(data, i, data[i]);
            } while (data[i] != i);
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
