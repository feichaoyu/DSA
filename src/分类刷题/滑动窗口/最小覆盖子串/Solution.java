package 分类刷题.滑动窗口.最小覆盖子串;

public class Solution {

    public String minWindow(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }

        // 滑动窗口内部包含多少T中的字符
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        // sliding window: s[left...right)，此时该区间长度为 right-left
        int left = 0;
        int right = 0;

        while (right < sLen) {
            // 窗口右边字符不在t中，则继续向右移动
            char charRight = charArrayS[right];
            if (tFreq[charRight] == 0) {
                right++;
                continue;
            }

            // 右边界元素在滑动窗口中出现的次数 < 在t中出现的次数
            if (winFreq[charRight] < tFreq[charRight]) {
                distance++;
            }
            // 滑动窗口内该字符出现次数加1
            winFreq[charRight]++;
            right++;

            while (distance == tLen) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }

                // 窗口左边字符不在t中，则继续向右移动
                char charLeft = charArrayS[left];
                if (tFreq[charLeft] == 0) {
                    left++;
                    continue;
                }

                // 左边界元素在滑动窗口中出现的次数 == 在t中出现的次数
                if (winFreq[charLeft] == tFreq[charLeft]) {
                    distance--;
                }
                // 滑动窗口内该字符出现次数减1
                winFreq[charLeft]--;
                left++;
            }
        }

        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
