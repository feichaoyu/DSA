package 数据结构.栈;

/**
 * @Author feichaoyu
 * @Date 2019/12/26
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
