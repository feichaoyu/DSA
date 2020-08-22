package 剑指offer._39_MoreThanHalfNumber;

/**
 * 正负抵消
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author feichaoyu
 */
public class Solution3 {

    public int majorityElement(int[] nums) {

        // 初始化为数组的第一个元素，接下来用于记录上一次访问的值
        int target = nums[0];
        // 用于记录出现次数
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
            } else {
                count--;
            }
            // 当count=0时，更换target的值为当前访问的数组元素的值，次数设为1
            if (count == 0) {
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
}
