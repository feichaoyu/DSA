package 算法.lfu;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Cahce全局类
 *
 * @author feichaoyu
 */
public class CacheGlobal {
    /**
     * 全局缓存对象
     */
    public static ConcurrentMap<String, MyCache> concurrentMap = new ConcurrentHashMap<>();
}
