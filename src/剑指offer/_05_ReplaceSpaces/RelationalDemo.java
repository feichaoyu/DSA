package 剑指offer._05_ReplaceSpaces;

import java.util.Arrays;

/**
 * 两个排序数组 A1 和 A2，把 A2 中所有数字插入到 A1 中。
 *
 * @author feichaoyu
 */
public class RelationalDemo {

    public static int[] arrangeSortedArray(int[] a1, int[] a2) {

        if (a1 == null || a1.length <= 0 || a2 == null || a2.length <= 0) {
            return null;
        }

        int[] newData = new int[a1.length + a2.length];
        for (int i = 0; i < a1.length; i++) {
            newData[i] = a1[i];
        }

        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = a1.length + a2.length - 1;
        while (k >= 0) {

            if (i < 0 || j < 0) {
                break;
            }

            // 以后操作 newData（a1） 和 a2
            if (newData[i] > a2[j]) {
                newData[k--] = newData[i--];
            } else {
                newData[k--] = a2[j--];
            }
        }

        if (i < 0) {
            // 如果 a2 剩余，则把 a2 中的剩余元素依次移动到 newData（a1） 的前端；若 newData（a1）剩余则证明已经排好
            while (j >= 0) {
                newData[k--] = a2[j--];
            }
        }

        return newData;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 9};
        int[] a2 = {2, 4, 6, 8, 10};
        int[] result = arrangeSortedArray(a1, a2);
        System.out.println(Arrays.toString(result));
    }
}
