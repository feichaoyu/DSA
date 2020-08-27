package 分类刷题.动态规划.摆动序列;

/**
 * 记忆化搜索
 */
public class Solution2 {

    private int[] up;

    private int[] down;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        up = new int[nums.length];
        down = new int[nums.length];
        return Math.max(getMaxLength(nums, 0, true), getMaxLength(nums, 0, false));
    }

    /**
     * 如果方法getMaxLength在一个上升摆动之后被调用，我们我们需要用这个方法找到下一个下降的元素。
     * 如果方法getMaxLength在一个下降元素之后被调用，那么我们需要用这个方法找到下一个上升的元素。
     *
     * @param nums  输入数组
     * @param index 记录我们从哪个位置开始找最长摆动序列
     * @param isUp  记录现在要找的是上升元素还是下降元素
     * @return
     */
    private int getMaxLength(int[] nums, int index, boolean isUp) {
        // 这里为什么要用两个数组来记忆？
        // 因为有上升和下降两种摆动序列，因此在递归时不一定在index处一定是上升或者下降序列，所以用两个数组来明确表示
        if (isUp && up[index] != 0) {
            return up[index];
        }
        if (!isUp && down[index] != 0) {
            return down[index];
        }

        int res = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if ((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index])) {
                res = Math.max(res, 1 + getMaxLength(nums, i, !isUp));
            }
        }

        if (isUp) {
            up[index] = res;
            return up[index];
        } else {
            down[index] = res;
            return down[index];
        }
    }
}
