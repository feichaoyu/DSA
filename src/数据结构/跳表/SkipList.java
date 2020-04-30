package 数据结构.跳表;

import java.util.Comparator;

/**
 * 在有序列表的基础上增加 “跳跃” 功能
 *
 * @author feichaoyu
 */
public class SkipList<K, V> {

    /**
     * 跳表的最大高度
     */
    private static final int MAX_LEVEL = 32;

    private static final double P = 0.25;

    private int size;

    /**
     * 跳表的有效高度
     */
    private int level;

    /**
     * 不存放任何K-V
     */
    private Node<K, V> first;

    private Comparator<K> comparator;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first = new Node<>(null, null, MAX_LEVEL);
    }

    public SkipList() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        Node<K, V> node = first;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                // 在当前层继续向右找
                node = node.nexts[i];
            }

            // 相等则找到
            if (cmp == 0) {
                return node.nexts[i].value;
            }

            // 否则进入下一层 i--
        }
        return null;
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        Node<K, V> node = first;
        Node<K, V>[] prevs = new Node[level];
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            // 存在则覆盖
            if (cmp == 0) {
                V oldV = node.nexts[i].value;
                node.nexts[i].value = value;
                return oldV;
            }
            prevs[i] = node;
        }

        // 新节点的层数
        int newLevel = randomLevel();
        // 添加新节点
        Node<K, V> newNode = new Node<>(key, value, newLevel);
        // 设置前驱和后继
        for (int i = 0; i < newLevel; i++) {
            // 如果之前的高度小于新的高度，那么只需要将first节点指向新节点即可，新节点指向null
            if (i >= level) {
                first.nexts[i] = newNode;
            } else {
                // 新节点的后继指向先前前驱的后继
                newNode.nexts[i] = prevs[i].nexts[i];
                // 先前前驱的后继指向新节点
                prevs[i].nexts[i] = newNode;
            }
        }

        // 节点数量增加
        size++;

        // 计算跳表的最终层数
        level = Math.max(level, newLevel);

        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        Node<K, V> node = first;
        Node<K, V>[] prevs = new Node[level];
        boolean exist = false;
        for (int i = level - 1; i >= 0; i--) {
            int cmp = -1;
            while (node.nexts[i] != null
                    && (cmp = compare(key, node.nexts[i].key)) > 0) {
                node = node.nexts[i];
            }
            if (cmp == 0) {
                exist = true;
            }
            prevs[i] = node;
        }
        if (!exist) {
            return null;
        }

        // 能走到这里，说明node的后继指向了需要删除的节点，且处于最底层

        // 需要被删除的节点
        Node<K, V> removedNode = node.nexts[0];

        // 数量减少
        size--;

        // 设置后继
        for (int i = 0; i < removedNode.nexts.length; i++) {
            prevs[i].nexts[i] = removedNode.nexts[i];
        }

        // 更新跳表的高度
        int newLevel = level;
        while (--newLevel >= 0 && first.nexts[newLevel] == null) {
            level = newLevel;
        }

        return removedNode.value;
    }

    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    private int compare(K k1, K k2) {
        return comparator != null
                ? comparator.compare(k1, k2)
                : ((Comparable<K>) k1).compareTo(k2);
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            nexts = new Node[level];
        }

        @Override
        public String toString() {
            return key + ":" + value + "_" + nexts.length;
        }
    }

}
