package 分类刷题.回溯.分割回文串;

import java.util.*;

public class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }

        LinkedList<String> path = new LinkedList<>();
        backtrace(s, 0, s.length(), path, res);
        return res;
    }

    /**
     * @param s     给定字符串
     * @param start 起始字符的索引
     * @param len   字符串s的长度
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    private void backtrace(String s, int start, int len, LinkedList<String> path, List<List<String>> res) {

        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            // 不是回文字符串下面就不考虑了，剪枝操作
            if (!checkPalindrome(s, start, i)) {
                continue;
            }

            path.addLast(s.substring(start, i + 1));
            backtrace(s, i + 1, len, path, res);
            // 回溯
            path.removeLast();
        }
    }

    /**
     * 判断字符串是否是回文串
     *
     * @param str   给定字符串
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

