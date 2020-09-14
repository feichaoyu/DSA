package 剑指offer._40_最小的K个数;

/**
 * 计数排序，仅限于数据范围有限时，时间复杂度可以为 O(n)
 *
 * @author feichaoyu
 */
public class Solution3 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        // 题目给定：0 <= k <= arr.length <= 10000
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int i = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && i < k) {
                res[i++] = num;
            }
            if (i == k) {
                break;
            }
        }
        return res;
    }
}
