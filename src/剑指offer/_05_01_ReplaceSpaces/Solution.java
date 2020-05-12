package 剑指offer._05_01_ReplaceSpaces;

/**
 * 从后向前遍历
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author feichaoyu
 */
public class Solution {

    public static String replaceSpace(String s) {

        char[] data = s.toCharArray();
        int length = s.length();

        if (length == 0) {
            return "";
        }

        int newLength = data.length;
        for (char e : data) {
            if (e == ' ') {
                newLength += 2;
            }
        }
        char[] newData = new char[newLength];
        // 复制到新数组，后面全部操作新数组
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        // p1 指向原来字符串的最后一个位置
        int p1 = length - 1;
        // p2 指向新字符串的最后一个位置
        int p2 = newLength - 1;
        while (p1 >= 0 && p1 != p2) {
            // p1 移动到空格处，p2 开始替换
            if (newData[p1] == ' ') {
                newData[p2--] = '0';
                newData[p2--] = '2';
                newData[p2] = '%';
            } else {
                newData[p2] = newData[p1];
            }
            p1--;
            p2--;
        }
        return String.valueOf(newData);
    }

    public static void main(String[] args) {

        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
