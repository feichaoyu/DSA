package 分类刷题.队列.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Based on LinkedHashMap
 */
public class LRU2 extends LinkedHashMap<Integer, Integer> {

    /**
     * 缓存大小
     */
    private int cacheSize;

    public LRU2(int cacheSize) {
        super(cacheSize, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > cacheSize;
    }

    public void print() {
        System.out.println(super.toString());
    }

    public static void main(String[] args) {

        LRU2 cache = new LRU2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();                          // {1=1, 2=2} 右边是头
        System.out.println(cache.get(1));       // 返回  1
        cache.print();                          // {2=2, 1=1}
        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
        cache.print();                          // {3=3, 4=4}
    }
}
