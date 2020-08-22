package 数据结构.树.Trie;

/**
 * @Author feichaoyu
 * @Date 2020/1/8
 */
public class TrieMapTest {

    public static void main(String[] args) {
        TrieMap<Integer> map = new TrieMap<>();
        map.put("cat", 1);
        map.put("dog", 10);
        map.put("dogdog", 100);

        System.out.println(map.get("dog"));
        map.remove("dogd");
        System.out.println(map.get("dog"));

        System.out.println(map.startWith("c"));
    }

}
