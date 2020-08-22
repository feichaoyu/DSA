package 分类刷题.回溯.组合总和;

import java.util.*;

public class Solution2 {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            // 前一个元素和当前元素相等，则会产生重复，剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.addLast(candidates[i]);
            backtrace(candidates, target - candidates[i], i + 1, list);
            list.removeLast();

        }
    }

}
