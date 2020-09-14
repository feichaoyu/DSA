package 考试;

import java.util.Arrays;

public class Main24 {
    public static int[] mergeSortedArray(int[] array1, int[] array2) {

        if (array1 == null || array1.length <= 0 || array2 == null || array2.length <= 0) {
            return new int[0];
        }

        int[] newData = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            newData[i] = array1[i];
        }

        Arrays.sort(array2);

        int i = array1.length - 1;
        int j = array2.length - 1;
        int k = array1.length + array2.length - 1;
        while (i >= 0 && j >= 0) {
            newData[k--] = (newData[i] < array2[j]) ? array2[j--] : newData[i--];
        }

        if (i < 0) {
            // 如果 array2 剩余，则把 array2 中的剩余元素依次移动到 newData（array1） 的前端；若 newData（array1）剩余则证明已经排好
            while (j >= 0) {
                newData[k--] = array2[j--];
            }
        }

        return newData;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 9};
        int[] a2 = {10, 8, 6, 4, 2};
        int[] result = mergeSortedArray(a1, a2);
        System.out.println(Arrays.toString(result));
    }
}
