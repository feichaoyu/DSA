package 数据结构.堆;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

/**
 * @author feichaoyu
 */
public class TopK<E> {

    private PriorityQueue<E> p;
    private int k;

    public TopK(int k) {
        this.k = k;
        this.p = new PriorityQueue<>(k);
    }

    public void addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
    }

    public void add(E e) {
        // 未满k个时，直接添加
        if (p.size() < k) {
            p.add(e);
            return;
        }

        Comparable<? super E> head = (Comparable<? super E>) p.peek();
        if (head.compareTo(e) >= 0) {
            // 小于等于TopK中的最小值，不用变
            return;
        }
        // 否则，新元素替换原来的最小值
        p.poll();
        p.add(e);
    }

    /**
     * 获取当前的最大的K个元素
     *
     * @param a   返回类型的空数组
     * @param <T>
     * @return TopK以数组形式
     */
    public <T> T[] toArray(T[] a) {
        return p.toArray(a);
    }

    /**
     * 获取第K个最大的元素
     *
     * @return
     */
    public E getKth() {
        return p.peek();
    }

    public static void main(String[] args) {
        TopK<Integer> top5 = new TopK<>(5);
        top5.addAll(Arrays.asList(100, 1, 5, 7, 34, 9, 5, 23, 21, 90));
        System.out.println("top5：" + Arrays.toString(top5.toArray(new Integer[0])));
        System.out.println("5th：" + top5.getKth());
    }

}
