package 练习题.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 找数组中元素的最大值和最小值
 */
public class Case2 {

    private static int max;

    private static int min;

    /**
     * 分治：非递归
     * 1.将数组两两一对分组，如果数组元素个数为奇数个，就把最后一个元素单独分为一组，然后分别对每一组中相邻两个元素进行比较，
     * 把两者中较小的数放在数组的左边，较大的数放在数组的右边，只需要比较 n/2 次就可以把数组分组完成。
     * 2.由于最小值一定在数组左边，最大值一定在数组右边。因此只需要在每一组的左边部分找最小值，右边部分找最大值，查找需要
     * n/2-1 次，比较也需要 n/2-1 次，总共需要 3n/2-2 次，相比暴力法的 2n-2 次少了 n/2 次。
     *
     * @param arr
     */
    public static void getMaxAndMin(int[] arr) {
        if (arr == null) {
            System.out.println("参数不合法");
            return;
        }
        int len = arr.length;
        // 两两分组，较小的数放到左半部分，较大的数放到右半部分
        for (int i = 0; i < len - 1; i += 2) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        // 在各个分组的左半部分找最小值
        min = arr[0];
        for (int i = 2; i < len; i += 2) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 在各个分组的右半部分找最大值
        max = arr[1];
        for (int i = 3; i < len; i += 2) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 如果数组中元素个数是奇数个，最后一个元素被分成一组，需要特殊处理
        if (len % 2 == 1) {
            if (max < arr[len - 1]) {
                max = arr[len - 1];
            }
            if (min > arr[len - 1]) {
                min = arr[len - 1];
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 分治：递归
     * 1.将数组分为左右两部分，先求出左半部分的最大值和最小值，再求出右半部分的最大值和最小值
     * 2.左右两部分的最大值中的较大值即为合并后的数组的最大值，左右两部分的最小值中的较小值即为合并后的数组的最小值
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public static List<Integer> getMaxAndMin(int[] arr, int l, int r) {
        if (arr == null) {
            System.out.println("参数不合法");
            return null;
        }
        List<Integer> list = new ArrayList<>(2);
        int m = l + (r - l) / 2;
        int max, min;
        // 数组中只有一个元素
        if (l == r) {
            list.add(arr[l]);
            list.add(arr[l]);
            return list;
        }
        // 数组中刚好有两个元素
        if (l + 1 == r) {
            if (arr[l] > arr[r]) {
                max = arr[l];
                min = arr[r];
            } else {
                max = arr[r];
                min = arr[l];
            }

            list.add(min);
            list.add(max);
        }
        // 递归计算左半部分
        List<Integer> left = getMaxAndMin(arr, l, m);
        // 递归计算右半部分
        List<Integer> right = getMaxAndMin(arr, m + 1, r);
        // 总的最小值
        min = (left.get(0) < right.get(0)) ? left.get(0) : right.get(0);
        // 总的最大值
        max = (left.get(1) > right.get(1)) ? left.get(1) : right.get(1);

        list.add(min);
        list.add(max);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 19, 40, 4, 7, 1};
        getMaxAndMin(arr);
        System.out.println("max=" + max + " ,min=" + min);

        List<Integer> maxAndMin = getMaxAndMin(arr, 0, arr.length - 1);
        System.out.println("max=" + maxAndMin.get(1) + " ,min=" + maxAndMin.get(0));
    }
}
