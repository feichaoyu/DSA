package 数据结构.布隆过滤器;

/**
 * @author feichaoyu
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        // Test1
        BloomFilter<Integer> bf = new BloomFilter<>(1_000_000, 0.01);
        for (int i = 1; i <= 1_000_000; i++) {
            bf.put(i);
        }

        int count = 0;
        // 测试误判率
        for (int i = 1_000_000; i <= 2_000_000; i++) {
            if (bf.contains(i)) {
                count++;
            }
        }
        System.out.println("误判个数：" + count);
    }
}
