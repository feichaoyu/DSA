package 分类刷题.动态规划.最长回文子串;

public class Solution2 {

    /**
     * 定义状态为：dp[i][j]表示子串s[i..j]是否是回文子串，这里子串s[i..j]定义为左闭右闭区间，可以取到s[i]和s[j]
     * 状态转移：dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
     * 边界条件是：表达式[i + 1, j - 1]不构成区间，即长度严格小于2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3
     * 这个结论很显然：j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，其实只需要判断一下头尾两个字符是否相等就可以直接下结论了
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();

        // 初始化，主对角线上一定是true，即单个字符s[i]一定是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[j] != chars[i]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
