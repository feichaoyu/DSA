package 分类刷题.动态规划.最长回文子串;

public class Solution3 {

    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0,1);

        // 中心位置枚举到len-2
        for (int i = 0; i < len - 1; i++) {
            // 奇数串
            String oddStr = centerSpread(s, i, i);
            // 偶数串
            String evenStr = centerSpread(s, i, i + 1);
            // 找到奇数串和偶数串中最长的就是最长回文串
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        // 注意这里取不到left和right
        return s.substring(left + 1, right);
    }
}
