package 剑指offer._46_TranslateNumbersToStrings;

import java.util.Arrays;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Solution1 {

    private int[] memo;

    public int translateNum(int num) {

        String s = String.valueOf(num);
        memo = new int[11];
        Arrays.fill(memo, -1);
        return dfs(s, 0);
    }

    private int dfs(String s, int index) {
        int n = s.length();
        if (index == n) {
            return 1;
        }
        if (memo[index] != -1) {
            return memo[index];
        }

        if (index == n - 1 || s.charAt(index) == '0' || s.substring(index, index + 2).compareTo("25") > 0) {
            memo[index + 1] = dfs(s, index + 1);
            return memo[index + 1];
        }
        memo[index + 1] = dfs(s, index + 1);
        memo[index + 2] = dfs(s, index + 2);
        return memo[index + 1] + memo[index + 2];
    }
}
