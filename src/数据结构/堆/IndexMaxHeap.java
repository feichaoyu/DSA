package 数据结构.堆;

import 数据结构.数组.Array;

/**
 * 索引堆（最大堆）
 *
 * @author feichaoyu
 */
public class IndexMaxHeap<E extends Comparable> {
    /**
     * 最大索引堆中的数据
     */
    private Array<E> data;

    /**
     * 最大索引堆中的索引
     */
    private Array<Integer> indexes;

    /**
     * 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x
     */
    private Array<Integer> reverse;

    public IndexMaxHeap(int capacity) {
        data = new Array<>(capacity);
        indexes = new Array<>(capacity);
        reverse = new Array<>(capacity);
        for (int i = 0; i <= capacity; i++) {
            // 每个元素索引都是-1表示不存在
            reverse.add(i, -1);
        }
    }

    public IndexMaxHeap() {
        data = new Array<>();
        indexes = new Array<>();
    }

    /**
     * 返回索引堆中元素个数
     *
     * @return
     */
    public int size() {
        return indexes.getSize();
    }

    /**
     * 判断索引堆中元素是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return indexes.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向最大索引堆中插入一个新的元素, 新元素的索引为i, 元素为e
     *
     * @param e
     */
    public void add(int i, E e) {
        data.add(i, e);
        // 若indexes[i] = j ，则reverse[j] =i
        indexes.add(indexes.getSize(), i);
        reverse.add(i, indexes.getSize());
        siftUp(indexes.getSize() - 1);
    }

    private void siftUp(int k) {
        // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
        while (k > 0 && data.get(indexes.get(parent(k))).compareTo(data.get(indexes.get(k))) < 0) {
            // 交换的是索引
            indexes.swap(k, parent(k));

            reverse.set(indexes.get(k), k);
            reverse.set(indexes.get(parent(k)), parent(k));

            k = parent(k);
        }
    }

    /**
     * 查看堆中最大元素
     *
     * @return
     */
    public E findMax() {
        if (indexes.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty!");
        }
        return data.get(indexes.get(0));
    }

    /**
     * 获取最大索引堆中的堆顶元素的索引
     *
     * @return
     */
    public int getMaxIndex() {
        return indexes.get(0);
    }

    /**
     * 获取最大索引堆中索引为i的元素
     *
     * @param i
     * @return
     */
    public E getElement(int i) {

        if (reverse.get(i) == -1) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data.get(i);
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        indexes.swap(0, indexes.getSize() - 1);

        reverse.set(indexes.get(0), 0);
        // 不需要了，赋值-1
        reverse.set(indexes.get(indexes.getSize() - 1), -1);

        // 只需要移除索引，数据不需要移除，因此size大小应该看indexes的
        indexes.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < indexes.getSize()) {
            int j = leftChild(k);
            if (j + 1 < indexes.getSize() && data.get(indexes.get(j + 1)).compareTo(data.get(indexes.get(j))) > 0) {
                j = rightChild(k);
                // data[j]是leftChild和rightChild中的最大值
            }

            // 如果父节点比左右孩子中的最大值还要大，那么说明没有问题，直接退出
            if (data.get(indexes.get(k)).compareTo(data.get(indexes.get(j))) >= 0) {
                break;
            }
            // 否则交换
            indexes.swap(k, j);

            reverse.set(indexes.get(k), k);
            reverse.set(indexes.get(j), j);

            k = j;
        }
    }

    /**
     * 取出堆中最大元素，并替换成元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(indexes.get(0), e);
        return ret;
    }

    /**
     * 将最大索引堆中索引为i的元素修改为e
     *
     * @param i
     * @param e
     */
    public void change(int i, E e) {

        if (reverse.get(i) == -1) {
            throw new IllegalArgumentException("Index is illegal.");
        }

        data.set(i, e);

        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后siftUp(j), 再siftDown(j)   O(n)
//        for (int j = 0; j < indexes.getSize(); j++) {
//            if (indexes.get(j) == i) {
//                // 这里既需要siftUp，也需要siftDown，因为当前元素处于整个数组中间，相当于前半部分需要siftUp，后半部分需要siftDown
//                siftUp(j);
//                siftDown(j);
//                return;
//            }
//        }

        // O(1)
        int j = reverse.get(i);
        siftUp(j);
        siftDown(j);
    }
}
