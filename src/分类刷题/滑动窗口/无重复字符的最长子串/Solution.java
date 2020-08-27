package 分类刷题.滑动窗口.无重复字符的最长子串;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int sLen = s.length();
        char[] charArrayS = s.toCharArray();

        // 最多128个ASCII码字符
        int[] winFreq = new int[128];

        // sliding window: s[left...right)，此时该区间长度为 right-left
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < sLen) {
            char charRight = charArrayS[right];
            // 右边界字符没有出现过
            if (winFreq[charRight] == 0) {
                // 频率+1
                winFreq[charRight]++;
                right++;
            }
            // 右边界字符之前已经出现过
            else {
                // 左边界右移直到滑动窗口中不包含重复字符
                while (winFreq[charRight] != 0) {
                    char charLeft = charArrayS[left];
                    winFreq[charLeft]--;
                    left++;
                }
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
