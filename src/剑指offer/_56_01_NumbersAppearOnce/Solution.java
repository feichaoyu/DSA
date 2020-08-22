package 剑指offer._56_01_NumbersAppearOnce;

/**
 * @author feichaoyu
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {

        // 对所有数字进行异或运算
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        // 找到第一位不是0的
        int mask = 1;
        while ((res & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            // 根据该位是否为0将其分为两组
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}
