package 数据结构.布隆过滤器;

/**
 * 降低误判率的方法：
 * 1、增加数组的长度
 * 2、增加hash函数的个数
 *
 * @author feichaoyu
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        // BloomFilter
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

        // BloomFilter2
        BloomFilter2<Integer> bf2 = new BloomFilter2<>(1_000_000, 0.01);
        for (int i = 1; i <= 1_000_000; i++) {
            bf2.put(i);
        }

        int count2 = 0;
        // 测试误判率
        for (int i = 1_000_000; i <= 2_000_000; i++) {
            if (bf2.contains(i)) {
                count2++;
            }
        }
        System.out.println("误判个数：" + count2);

    }
}
