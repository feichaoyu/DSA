package 分类刷题.字符串.字典序排数;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            dfs(n, i);
        }
        return res;
    }

    private void dfs(int n, int index) {
        if (index > n) {
            return;
        }
        res.add(index);
        for (int i = 0; i < 10; i++) {
            dfs(n, index * 10 + i);
        }
    }
}
