package 剑指offer._15_NumberOf1InBinary;

/**
 * @author feichaoyu
 */
public class Solution1 {

    public int hammingWeight(int n) {
        // 假设 n 可能是是正数或负数，也就是有符号数，此时只能左移判断，右移判断只指针无符号数
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().hammingWeight(1));   // 1
        System.out.println(new Solution1().hammingWeight(Integer.MAX_VALUE));   // 31
        System.out.println(new Solution1().hammingWeight(-1));   // 32
        System.out.println(new Solution1().hammingWeight(Integer.MIN_VALUE));  // 1
        System.out.println(new Solution1().hammingWeight(0));  // 0
    }
}
