package 分类刷题.动态规划.最长公共子序列;

/**
 * 定义状态：dp[i,j] 表示text1[0...i]和text2[0...j]中最长公共子序列的长度
 * 状态转移：
 * 1.若text1[i] == text2[j]，则dp[i,j] = 1 + dp[i-1,j-1]
 * 2.若text1[i] != text2[j]，则dp[i,j] = max{dp[i-1,j], dp[i,j-1]}
 */
public class Solution1 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        // 注意这里是m+1 n+1，这样写不需要对0单独讨论，从1开始讨论
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

        return dp[m][n];
    }

    // 单独讨论0
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        dp[0][0] = text1.charAt(0) == text2.charAt(0) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], text1.charAt(i) == text2.charAt(0) ? 1 : 0);
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], text1.charAt(0) == text2.charAt(j) ? 1 : 0);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution1().longestCommonSubsequence2("1A2C3D4B56", "B1D23CA45B6A"));
    }
}
