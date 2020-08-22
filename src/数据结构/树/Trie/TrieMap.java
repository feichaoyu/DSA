package 数据结构.树.Trie;

import java.util.TreeMap;

/**
 * @Author feichaoyu
 * @Date 2020/1/7
 */
public class TrieMap<V> {

    private class Node {

        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node parent;
        public Character character;
        public V value;

        public Node(boolean isWord, Node parent) {
            this.isWord = isWord;
            this.parent = parent;
            next = new TreeMap<>();
            value = null;
        }

        public Node(Node parent) {
            this(false, parent);
        }

        public Node() {
            this(false, null);
        }
    }

    private Node root;
    private int size;

    public TrieMap() {
        root = new Node();
        size = 0;
    }

    /**
     * 获取Trie中存储的键值对数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 清空Trie
     */
    public void clear() {
        root = new Node();
        size = 0;
    }

    /**
     * 根据key获取对应的value
     *
     * @param key
     * @return
     */
    public V get(String key) {

        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                return null;
            }
            cur = cur.next.get(c);
        }
        return cur.value;
    }

    /**
     * 向Trie中添加键值对
     *
     * @param key
     * @param value
     */
    public void put(String key, V value) {

        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            Node childNode = cur.next.get(c);
            if (childNode == null) {
                childNode = new Node(cur);
                childNode.character = c;
                cur.next.put(c, childNode);
            }
            cur = cur.next.get(c);
        }

        // 新增
        if (!cur.isWord) {
            cur.isWord = true;
            cur.value = value;
            size++;
        }
        // 更新
        else {
            cur.value = value;
        }
    }

    /**
     * 删除键值对
     *
     * @param key
     * @return
     */
    public V remove(String key) {
        // 先找到最后一个节点
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                System.out.println("键不存在，删除失败");
                return null;
            }
            cur = cur.next.get(c);
        }

        // 如果key不是单词，不用作任何处理
        if (!cur.isWord) {
            System.out.println("当前key不是单词，删除失败");
            return null;
        }

        size--;
        V oldValue = cur.value;

        // 如果还有子节点
        if (cur.next != null && !cur.next.isEmpty()) {
            cur.isWord = false;
            cur.value = null;
            return oldValue;
        }

        // 没有子节点
        Node parent = null;
        while ((parent = cur.parent) != null) {
            parent.next.remove(cur.character);
            if (parent.isWord || !parent.next.isEmpty()) {
                break;
            }
            cur = parent;
        }

        return oldValue;
    }

    /**
     * 查询key是否在Trie中
     *
     * @param key
     * @return
     */
    public boolean contains(String key) {

        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 查询在Trie中是否有以prefix为前缀的key
     *
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
