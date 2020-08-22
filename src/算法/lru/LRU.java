package 算法.lru;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 哈希表+队列
 */
public class LRU<K, V> {

    /**
     * 缓存大小
     */
    private int cacheSize;

    /**
     * 双端队列
     */
    private ArrayDeque<K> queue = new ArrayDeque<>(cacheSize);

    /**
     * 哈希表
     */
    private HashMap<K, V> map = new HashMap<>(cacheSize);

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    /**
     * 判断缓存队列是否已满
     *
     * @return
     */
    private boolean isQueueFull() {
        return queue.size() == cacheSize;
    }

    public V get(K k) {
        if (map.get(k) != null) {
            queue.remove(k);
            queue.addLast(k);
            return map.get(k);
        }
        return null;
    }

    // 队列头部出来，队列尾部进入
    public void put(K k, V v) {
        if (!map.containsKey(k)) {
            // 如果队列满，需要删除队头key
            if (isQueueFull()) {
                map.remove(queue.pollFirst());
            }
            // 把新缓存的key添加到队尾
            queue.addLast(k);
            // 同时添加到哈希表中
            map.put(k, v);
        }
        // key已存在，判断不在队尾就删除，然后重新插入队尾
        else if (k != queue.getLast()) {
            queue.remove(k);
            queue.addLast(k);
        }
    }

    private void print() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (K key : queue) {
            str.append(key + "=" + map.get(key) + ", ");
        }
        System.out.println(str.substring(0, str.length() - 2) + "}");
    }

    public static void main(String[] args) {
        LRU<Integer, Integer> cache = new LRU<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();                          // {1=1, 2=2} 右边是头
        System.out.println(cache.get(1));       // 返回  1
        cache.print();                          // {2=2, 1=1}
        cache.put(3, 3);                  // 该操作会使得key 2 作废
        cache.print();                          // {1=1, 3=3}
        System.out.println(cache.get(2));       // 返回 null
        cache.put(4, 4);                  // 该操作会使得key 1 作废
        cache.print();                          // {3=3, 4=4}
        System.out.println(cache.get(1));       // 返回 null
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
        cache.print();                          // {3=3, 4=4}
    }
}
