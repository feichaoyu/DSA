package 分类刷题.动态规划.摆动序列;

import java.util.Arrays;

/**
 * 定义状态：
 * up[i]表示目前为止最长的以第i个元素结尾的上升摆动序列的长度
 * down[i]表示目前为止最长的以第i个元素结尾的下降摆动序列的长度
 *
 * 状态转移：
 * if nums[i] > nums[j], up[i] = max{up[i], down[j] + 1}    , j<i
 * if nums[i] < nums[j], down[i] = max{down[i], up[j] + 1}  , j<i
 */
public class Solution1 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        // 都是长度为1的摆动序列
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        return Math.max(down[nums.length - 1], up[nums.length - 1]);
    }
}
