package 剑指offer._58_02_左旋转字符串;

public class Solution {

    public String reverseLeftWords(String s, int n) {
        return leftRotateString(s, s.length(), n);
    }

    /**
     * 旋转字符串
     */
    private String reverseString(String s, int from, int to) {
        char[] chars = s.toCharArray();
        while (from < to) {
            char t = chars[from];
            chars[from++] = chars[to];
            chars[to--] = t;
        }
        return new String(chars);
    }

    /**
     * 将字符串左边元素移动到右边
     *
     * @param s 字符串
     * @param n 字符串的长度
     * @param m 移动的元素个数
     * @return 移动后的字符串
     */
    private String leftRotateString(String s, int n, int m) {
        m %= n;
        s = reverseString(s, 0, m - 1);
        s = reverseString(s, m, n - 1);
        s = reverseString(s, 0, n - 1);
        return s;
    }
}
