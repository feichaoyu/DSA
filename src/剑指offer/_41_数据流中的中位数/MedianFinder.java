package 剑指offer._41_数据流中的中位数;

import java.util.PriorityQueue;

/**
 * @author feichaoyu
 */
public class MedianFinder {

    private PriorityQueue<Integer> maxHeap;

    private PriorityQueue<Integer> minHeap;

    private int median;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (median == 0) {
            median = num;
            return;
        }

        if (num <= median) {
            // 小于等于中值，加入最大堆
            maxHeap.add(num);
        } else {
            // 大于中值，加入最小堆
            minHeap.add(num);
        }

        // 两边元素个数是否相差2
        if (minHeap.size() - maxHeap.size() == 2) {
            // 最小堆元素个数多，即大于中值的数多
            // 将 median 加入到最大堆中，然后将最小堆中的根移除赋给 median
            maxHeap.add(median);
            median = minHeap.poll();
        } else if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.add(median);
            median = maxHeap.poll();
        }
    }

    public double findMedian() {
        // 奇数个数字的情况
        if (minHeap.size() == maxHeap.size()) {
            return median;
        }
        // 偶数个数字的情况
        if (minHeap.size() - maxHeap.size() == 1) {
            return (median + minHeap.peek()) / 2.0;
        } else {
            return (median + maxHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
