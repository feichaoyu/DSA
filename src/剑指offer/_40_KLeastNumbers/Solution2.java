package 剑指offer._40_KLeastNumbers;

import java.util.PriorityQueue;

/**
 * 利用最大堆（前K个小的数），最小堆（前K个大的数）
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // PriorityQueue默认是最小堆，实现最大堆需要重写一下比较器
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int i = 0;
        for (int num : pq) {
            res[i++] = num;
        }
        return res;
    }
}
