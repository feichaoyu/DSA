package 分类刷题.回溯.组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        LinkedList<Integer> list = new LinkedList<>();
        generateCombination(n, k, 1, list);
        return res;
    }

    private void generateCombination(int n, int k, int index, LinkedList<Integer> list) {

        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.addLast(i);
            generateCombination(n, k, i + 1, list);
            list.removeLast();
        }
    }
}
