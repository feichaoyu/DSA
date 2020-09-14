package 剑指offer._38_字符串的排列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author feichaoyu
 */
public class Solution {

    List<String> res;

    boolean[] used;

    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        // 排序是为了去重方便
        Arrays.sort(chars);

        StringBuilder path = new StringBuilder();
        res = new LinkedList<>();
        used = new boolean[chars.length];

        backtrace(chars, 0, path);

        return res.toArray(new String[res.size()]);
    }

    private void backtrace(char[] chars, int index, StringBuilder path) {

        if (index == chars.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件
            // nums[i] == nums[i - 1] 即当前搜索的起点和上一次搜索的起点相同，则说明需要剪枝
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择

            // 这里i>0是因为for循环中初始i=0，对比组合总和2
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.append(chars[i]);

            backtrace(chars, index + 1, path);

            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
