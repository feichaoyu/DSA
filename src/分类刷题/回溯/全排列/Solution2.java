package 分类刷题.回溯.全排列;

import java.util.*;

public class Solution2 {

    private List<List<Integer>> res;

    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        used = new boolean[nums.length];

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        LinkedList<Integer> list = new LinkedList<>();
        backtrace(nums, 0, list);
        return res;
    }

    /**
     * 向这个排列的末尾添加第 index+1 个元素，获得一个有 index+1 个元素的排列
     *
     * @param nums
     * @param index
     * @param list
     */
    private void backtrace(int[] nums, int index, LinkedList<Integer> list) {

        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件
            // nums[i] == nums[i - 1] 即当前搜索的起点和上一次搜索的起点相同，则说明需要剪枝
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择

            // 这里i>0是因为for循环中初始i=0，对比组合总和2
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            list.addLast(nums[i]);
            backtrace(nums, index + 1, list);
            used[i] = false;
            list.removeLast();
        }
    }
}
