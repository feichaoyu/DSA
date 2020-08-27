package 分类刷题.动态规划.最长公共子序列;

/**
 * 定义状态：dp[i,j] 表示text1[0...i]和text2[0...j]中最长公共子序列的长度
 * 状态转移：
 * 1.若text1[i] == text2[j]，则dp[i,j] = 1 + dp[i-1,j-1]
 * 2.若text1[i] != text2[j]，则dp[i,j] = max{dp[i-1,j], dp[i,j-1]}
 */
public class Solution2 {


    public int[][] getDp(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    public String getLongestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.equals("") || text2.equals("")) {
            return "";
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = getDp(text1, text2);
        int m = chars1.length;
        int n = chars2.length;
        int maxLen = dp[m][n];
        char[] res = new char[maxLen];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chars1[m-1];
                m--;
                n--;
            }
        }
        return String.valueOf(res);

    }

    public static void main(String[] args) {
        System.out.println(new Solution2().getLongestCommonSubsequence("1A2C3D4B56", "B1D23CA45B6A"));
        System.out.println(new Solution2().getLongestCommonSubsequence("abcde", "ace"));
    }
}
