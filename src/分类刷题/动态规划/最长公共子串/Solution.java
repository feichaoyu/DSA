package 分类刷题.动态规划.最长公共子串;

import java.util.Arrays;

public class Solution {

    /**
     * 生成动态规划表 dp 之后，得到最长公共子串是非常容易的。
     * 比如，上边生成的 dp 中，最大值是 dp[3][4]==3，说明最长公共子串的长度为 3。
     * 最长公共子串的最后一个字符是 str1[3]， 当然也是 str2[4]，因为两个字符一样。
     * 那么最长公共子串为从 str1[3]开始向左一共 3 字节的子串，即 str1[1..3]，当然也是 str2[2..4]。
     * 总之，遍历 dp 找到最大值及其位置，最长公共子串自然可以得到
     */
    public String getLongestCommonSubStr2(String text1, String text2) {
        if (text1 == null || text2 == null || text1.equals("") || text2.equals("")) {
            return "";
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = longestCommonSubStr2(text1, text2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return text1.substring(end - max + 1, end + 1);
    }

    public String getLongestCommonSubStr(String text1, String text2) {
        if (text1 == null || text2 == null || text1.equals("") || text2.equals("")) {
            return "";
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = longestCommonSubStr(text1, text2);
        int end = 0;
        int max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (dp[i][j] > max) {
                    end = i - 1;
                    max = dp[i][j];
                }
            }
        }
        return text1.substring(end - max + 1, end + 1);
    }

    public int[][] longestCommonSubStr(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return new int[][]{};
        }

        // 注意这里是m+1 n+1，这样写不需要对0单独讨论，从1开始讨论
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        return dp;
    }

    // 单独讨论0
    public int[][] longestCommonSubStr2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return new int[][]{};
        }

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < n; j++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        Solution solution1 = new Solution();
        int[][] res = solution1.longestCommonSubStr("abcde", "bebcd");
        System.out.println("第一种方法获取的dp矩阵：");
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        System.out.println(solution1.getLongestCommonSubStr("abcde", "bebcd"));

        Solution solution2 = new Solution();
        int[][] res2 = solution2.longestCommonSubStr2("abcde", "bebcd");
        System.out.println("第二种方法获取的dp矩阵：");
        for (int i = 0; i < res2.length; i++) {
            System.out.println(Arrays.toString(res2[i]));
        }
        System.out.println(solution2.getLongestCommonSubStr2("abcde", "bebcd"));
    }
}
