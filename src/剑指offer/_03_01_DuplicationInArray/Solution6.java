package 剑指offer._03_01_DuplicationInArray;

import java.util.Arrays;

/**
 * 二分查找计数
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author feichaoyu
 */
public class Solution6 {

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

        if (data == null || data.length < 2) {
            return -1;
        }
        int start = 0;
        int end = data.length - 2;
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            int count = countRange(data, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    return -1;
                }
            }
            if (count > middle - start + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static int countRange(int[] data, int start, int end) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (start <= data[i] && end >= data[i]) {
                count++;
            }
        }
        return count;
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
