package 数据结构.集合Set;

/**
 * @Author feichaoyu
 * @Date 2020/1/2
 */
public interface Set<E> {
    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();

}
