package 分类刷题.队列.lru;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 哈希表+队列
 */
public class LRU {

    /**
     * 缓存大小
     */
    private int cacheSize;

    /**
     * 双端队列
     */
    private ArrayDeque<Integer> queue = new ArrayDeque<>(cacheSize);

    /**
     * 哈希表
     */
    private HashMap<Integer, Integer> map = new HashMap<>(cacheSize);

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

    public int get(int key) {
        int value = map.getOrDefault(key, -1);
        if (value != -1) {
            queue.remove(key);
            queue.addFirst(key);
        }
        return value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            // 如果队列满，需要删除队尾key
            if (isQueueFull()) {
                map.remove(queue.getLast());
                queue.pollLast();
            }
            // 把新缓存的key添加到队首
            queue.addFirst(key);
            // 同时添加到哈希表中
            map.put(key, value);
        }
        // key已存在，则删除之后，重新插入队头
        else if (key != queue.getFirst()) {
            queue.remove(key);
            queue.addFirst(key);
        }
    }

    private void print() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int key : queue) {
            str.append(key + "=" + map.get(key) + ", ");
        }
        System.out.println(str.substring(0, str.length() - 2) + "}");
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.print();                          // {2=2, 1=1} 左边是头
        System.out.println(cache.get(1));       // 返回  1
        cache.print();                          // {1=1, 2=2}
        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
        cache.print();                          // {4=4, 3=3}
    }
}
