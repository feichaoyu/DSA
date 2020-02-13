package 算法.排序算法.分布类排序.计数排序;

import java.util.Arrays;

/**
 * @author feichaoyu
 */
public class CountingSort {

    // 基于正整数的计数排序实现
    // 缺点：1.无法对负整数排序 2.浪费空间 3.是不稳定的排序
    public static void sort1(int[] array) {
        // 找出最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        } // O(n)

        // 开辟内存空间，存储每个整数出现的次数
        int[] counts = new int[1 + max];
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        } // O(n)

        // 根据整数的出现次数，对整数进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        } // O(n)
    }

    // 改进后的，是稳定的排序
    public static void sort2(int[] array) {
        // 找出最值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        // 开辟内存空间，存储次数
        int[] counts = new int[max - min + 1];
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }
        // 累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // 从后往前遍历元素，将它放到有序数组中的合适位置（可以保证稳定性）
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i] - min]] = array[i];
        }

        // 将有序数组赋值到array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }

    // 直接在sort1上修改以支持负整数，但还是不稳定的排序
    public static void sort3(int[] array) {
        // 找出最值
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        // 开辟内存空间，存储次数
        int[] counts = new int[max - min + 1];
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }

        // 根据整数的出现次数，对整数进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i + min;
            }
        } // O(n)
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 1, 3, 4, 5, 4, 3, 2};
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {-2, 1, 3, 4, 5, 4, 3, -2};
        sort2(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {-2, 1, 3, 4, 5, 4, 3, -2};
        sort2(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
