package 数据结构.堆;

import java.util.*;

/**
 * @author feichaoyu
 */
public class Median<E extends Comparable<E>> {

    /**
     * 最小堆
     */
    private PriorityQueue<E> minP;

    /**
     * 最大堆
     */
    private PriorityQueue<E> maxP;

    /**
     * 当前中位数
     */
    private E m;

    public Median() {
        this.minP = new PriorityQueue<>();
        this.maxP = new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private int compare(E e, E m) {
        return e.compareTo(m);
    }

    public void addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
    }

    public void add(E e) {
        // 第一个元素
        if (m == null) {
            m = e;
            return;
        }

        if (compare(e, m) <= 0) {
            // 小于等于中值，加入最大堆
            maxP.add(e);
        } else {
            // 大于中值，加入最小堆
            minP.add(e);
        }

        if (minP.size() - maxP.size() >= 2) {
            // 最小堆元素个数多，即大于中值的数多
            // 将 m 加入到最大堆中，然后将最小堆中的根移除赋给 m
            maxP.add(m);
            m = minP.poll();
        } else if (maxP.size() - minP.size() >= 2) {
            minP.add(m);
            m = maxP.poll();
        }

    }

    public E getMedian() {
        return m;
    }

    public static void main(String[] args) {
        Median<Integer> median = new Median<>();
        median.addAll(Arrays.asList(20, 30, 40, 50, 2, 4, 3, 5, 7, 8, 10));
        System.out.println(median.getMedian());
    }
}
