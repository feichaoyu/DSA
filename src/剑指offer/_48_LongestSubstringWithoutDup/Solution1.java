package 剑指offer._48_LongestSubstringWithoutDup;

/**
 * 滑动窗口
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int lengthOfLongestSubstring(String s) {

        // 最多256个ASCII码字符
        int[] freq = new int[256];

        // sliding window: s[l...r]
        // r初始化为-1是为了让窗口一开始不包含任何元素
        int l = 0, r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(r + 1)]++;
                r++;
            }
            // freq[s[r+1]] == 1
            else {
                freq[s.charAt(l)]--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().lengthOfLongestSubstring("abcabcbb"));
    }
}
