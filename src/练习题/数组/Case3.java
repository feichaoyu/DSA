package 练习题.数组;

/**
 * 求旋转数组的最小值
 * 把一个有序数组最开始的若干个元素移动到数组的末尾，称为数组的旋转，，输入一个排好序数组的一个旋转，输出旋转数组的最小元素
 * 例如{3,4,5,1,2}是{1,2,3,4,5,}的一个旋转，该数组的最小值为1
 */
public class Case3 {

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println(getMin(arr1));
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(getMin(arr2));
        int[] arr3 = {1, 1, 1, 1, 1};
        System.out.println(getMin(arr3));
        int[] arr4 = {1, 0, 1, 1, 1};
        System.out.println(getMin(arr4));
    }

    public static int getMin(int[] arr) {
        if (arr == null) {
            System.out.println("参数不合法");
            return -1;
        } else {
            return getMin(arr, 0, arr.length - 1);
        }
    }

    /**
     * 旋转数组元素的构成：先递增，然后突然降为最小值，然后再递增
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int getMin(int[] arr, int left, int right) {
        // 如果没有旋转(发生旋转的话第一个元素应该大于等于最后一个元素)，直接返回数组头元素
        if (left > right) {
            return arr[0];
        }
        // 只剩一个元素一定是最小值
        if (left == right) {
            return arr[left];
        }

        // 防止溢出写法
        int mid = left + ((right - left) >> 1);

        if (mid > 0 && arr[mid] < arr[mid - 1]) {
            return arr[mid];
        } else if (mid + 1 < arr.length && arr[mid + 1] < arr[mid]) {
            return arr[mid + 1];
        }
        // 最小值在数组左边
        else if (arr[right] > arr[mid]) {
            return getMin(arr, left, mid - 1);
        }
        // 最小值在数组右边
        else if (arr[mid] > arr[left]) {
            return getMin(arr, mid + 1, right);
        }
        // arr[left] == arr[mid] && arr[mid] == arr[right]
        // 这种情况下无法确定最小值所在的位置，需要在左右两边分别查找最小值，然后取其中的较小值
        // 比如{2,2,2,1,2},{2,1,2,2,2,2,2}
        else {
            return Math.min(getMin(arr, left, mid - 1), getMin(arr, mid + 1, right));
        }
    }
}
