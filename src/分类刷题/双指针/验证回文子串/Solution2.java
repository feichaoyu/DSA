package 分类刷题.双指针.验证回文子串;

public class Solution2 {

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            // 从左向右开始找到字母或数字
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // 从右向左开始找到字母或数字
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
