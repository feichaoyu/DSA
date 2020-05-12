package 剑指offer._16_Power;

/**
 * @author feichaoyu
 */
public class Solution {

    /**
     *       {  x^(n/2) * x^(n/2) ,n为偶数
     * x^n = {
     *       {  x^(n-1) * x = x^((n-1)/2) * x^((n-1)/2) ,n为奇数
     *
     * @param x 底数
     * @param n 指数
     * @return x^n
     */
    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1 / quickMul(x, -N);

    }

    private static double quickMul(double x, long n) {
        // 0的任意次方为0
        if (n == 0) {
            return 1;
        }

        // 指数为1，返回底数
        if (n == 1) {
            return x;
        }

        double result = quickMul(x, n >> 1);
        result *= result;
        // 指数为奇数的话，还需多乘一个底数，比如 2^15 = 2^7 * 2^7 * 2
        if ((n & 1) == 1) {
            result *= x;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("2^3=" + myPow(2, 3));
        System.out.println("2^-3=" + myPow(2, Integer.MIN_VALUE));
        System.out.println("0^3=" + myPow(0, 3));
        System.out.println("0^-3=" + myPow(0, -3));
    }
}
