package 分类刷题.字符串.旋转字符串;

public class Solution {

    // 这道题是每次移动一个首位字符放到字符串末尾，时间复杂度是O(n)
    // 如果可以一次移动 m 个字符到末尾，用下面的旋转方法也可以实现O(n)的时间复杂度，而不是O(mn)
    public boolean rotateString(String A, String B) {
        if ("".equals(A) && "".equals(B)) {
            return true;
        }
        int n = A.length();
        for (int i = 0; i < n; i++) {
            A = leftRotateString(A, n, 1);
            System.out.println(A);
            if (A.equals(B)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 旋转字符串
     *
     * @param s
     * @param from
     * @param to
     * @return
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

    public static void main(String[] args) {
        new Solution().rotateString("abcde", "cdeab");
    }
}
