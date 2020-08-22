package 剑指offer._46_TranslateNumbersToStrings;

/**
 * 动态规划
 * 状态方程：记数字num第i位数字为num[i]，则dp[i]表示以num[i]结尾的数字的翻译方案数
 * 状态转移：
 * dp[i] = dp[i-1]          , num[i]和num[i-1]不能合成一个字符
 * dp[i] = dp[i-1] + dp[i-2], num[i]和num[i-1]能合成一个字符
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int translateNum(int num) {

        String s = String.valueOf(num);
        // 数字num最大为 2^31，所以它的长度不会超过11
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '0' || s.substring(i - 1, i + 1).compareTo("25") > 0) {
                dp[i + 1] = dp[i];
            } else {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
