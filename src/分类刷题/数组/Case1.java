package 分类刷题.数组;

import java.util.HashMap;

/**
 * 找出数组中唯一的重复元素
 */
public class Case1 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 3};
        System.out.println(method1(arr));
        System.out.println(method2(arr));
    }

    /**
     * 方法一：利用哈希表，使用了辅助空间
     * 思路：
     * 1.第一次出现的元素，放入哈希表中
     * 2.以后再次出现这个元素就表示是重复元素
     *
     * @param arr
     * @return
     */
    public static int method1(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                result = key;
            }
        }
        return result;
    }

    /**
     * 方法二：利用异或运算的性质，不使用辅助空间
     * 异或运算的性质是：
     * 1.相同元素异或，结果为0
     * 2.不同元素异或，结果不为0
     * 3.任何数与0异或，结果为该数本身
     * 4.任何数与自身异或2次，结果为该数本身
     * 思路：数组中元素逐一异或，然后再与数字1,2,3...N异或，最终结果就是重复元素
     *
     * @param arr
     * @return
     */
    public static int method2(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int result = 0;
        // 先与数组中元素逐一异或
        for (int e : arr) {
            result ^= e;
        }
        // 再与数字1,2,3...N异或
        for (int i = 1; i < arr.length; i++) {
            result ^= i;
        }
        return result;
    }
}

