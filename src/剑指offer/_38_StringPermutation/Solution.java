package 剑指offer._38_StringPermutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author feichaoyu
 */
public class Solution {

    List<String> res = new LinkedList<>();

    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        generatePermutation(0, chars);
        return res.toArray(new String[res.size()]);
    }

    private void generatePermutation(int x, char[] chars) {

        if (x == chars.length - 1) {
            // 添加排列方案
            res.add(String.valueOf(chars));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            // 重复剪枝
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            // 交换，将 chars[i] 固定在第 x 位
            swap(chars, i, x);
            // 接着固定第 x + 1 位字符
            generatePermutation(x + 1, chars);
            // 恢复交换
            swap(chars, i, x);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
