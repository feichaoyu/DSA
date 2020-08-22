package 数据结构.树.线段树;

/**
 * @Author feichaoyu
 * @Date 2020/1/4
 */
public interface Merger<E> {
    E merge(E a, E b);
}
