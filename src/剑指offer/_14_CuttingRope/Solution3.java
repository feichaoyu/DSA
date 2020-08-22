package 剑指offer._14_CuttingRope;

/**
 * 贪心算法
 *
 * @author feichaoyu
 */
public class Solution3 {

    /**
     * 算法的整体思路是：
     * n 除 3 的结果为 a，余数是 b
     * 当 b 为 0，直接将 a 个 3 相乘
     * 当 b 为 1，将（a-1）个 3 相乘，再乘以 4
     * 当 b 为 2，将 a 个 3 相乘，再乘以 2
     */
    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1;
        }
        // a表示n能拆成的3的个数
        int a = n / 3;
        int b = n % 3;

        // n是3的倍数
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        // n是3k + 1，例如7。拆成3、3、1。由于有1对结果无法有贡献，所以最后的3、1换成4
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

}
