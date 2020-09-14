package 剑指offer._58_01_翻转单词顺序;

public class Solution {

    public String reverseWords(String s) {
        // 删除首尾空格
        s = s.trim();
        // 双指针
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                // 搜索首个空格
                i--;
            }
            // 添加单词
            res.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                // 跳过单词间空格
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }
}
