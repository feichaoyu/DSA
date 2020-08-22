package 分类刷题.回溯.全排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    private List<List<Integer>> res;

    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        used = new boolean[nums.length];
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
            if (!used[i]) {
                used[i] = true;
                list.addLast(nums[i]);
                backtrace(nums, index + 1, list);
                used[i] = false;
                list.removeLast();
            }
        }
    }
}
