package 数据结构.映射Map;

/**
 * @Author feichaoyu
 * @Date 2020/1/2
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
