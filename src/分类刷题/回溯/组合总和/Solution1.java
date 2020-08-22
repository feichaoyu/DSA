package 分类刷题.回溯.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        // 排序是为了提前终止搜索
        Arrays.sort(candidates);
        backtrace(candidates, target, 0, list);
        return res;
    }

    private void backtrace(int[] candidates, int target, int begin, LinkedList<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 在数组有序的前提下，剪枝
            if (target - candidates[i] < 0) {
                break;
            }

            list.addLast(candidates[i]);
            backtrace(candidates, target - candidates[i], i, list);
            list.removeLast();
        }
    }
}
