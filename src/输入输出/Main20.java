package 输入输出;

public class Main20 {

    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        char[] charArrayS = s.toCharArray();
        int[] freq = new int[128];

        int res = 0;
        int left = 0, right = 0;
        while (right < sLen) {
            char charRight = charArrayS[right];
            if (freq[charRight] == 0) {
                freq[charRight]++;
                right++;
            } else {
                while (freq[charRight] != 0) {
                    char charLeft = charArrayS[left];
                    if (freq[charLeft] != 0) {
                        freq[charLeft]--;
                    }
                    left++;
                }

            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
