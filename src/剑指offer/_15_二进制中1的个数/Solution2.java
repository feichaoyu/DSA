package 剑指offer._15_二进制中1的个数;

/**
 * @author feichaoyu
 */
public class Solution2 {

    /**
     * 结论：把一个整数减去1，再和原来的整数做与运算，会把该整数最右边的1变成0。
     * 那么一个整数有多少个1，就进行多少次这样的操作。
     *
     * 比如：1100 - 1 = 1011
     *               & 1100
     *               = 1000 - 1 = 0111
     *                          & 1100
     *                          = 0000
     *                          一共操作两次，有2个1
     */
    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().hammingWeight(1));   // 1
        System.out.println(new Solution2().hammingWeight(Integer.MAX_VALUE));   // 31
        System.out.println(new Solution2().hammingWeight(-1));   // 32
        System.out.println(new Solution2().hammingWeight(Integer.MIN_VALUE));  // 1
        System.out.println(new Solution2().hammingWeight(0));  // 0
    }
}
