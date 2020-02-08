package 数据结构.树.Trie;

/**
 * @Author feichaoyu
 * @Date 2020/1/8
 */
public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("cat");
        trie.add("deer");
        trie.add("door");

        System.out.println(trie.search("d..r"));
    }

}
