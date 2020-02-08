package 数据结构.队列;

/**
 * @Author feichaoyu
 * @Date 2019/12/26
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
