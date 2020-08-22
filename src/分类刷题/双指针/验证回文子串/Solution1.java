package 分类刷题.双指针.验证回文子串;

public class Solution1 {

    public boolean isPalindrome(String s) {

        if (s.length() == 1 || "".equals(s)) {
            return true;
        }

        // 字符串预处理
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toLowerCase().toCharArray();
        for (char c : chars) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }

        // 开始判断
        String str = sb.toString();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
