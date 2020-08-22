package 分类刷题.回溯.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 电话数字对照表
     */
    private static String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    /**
     * 获取和digits[index]匹配的字母，获得digits[0...index]翻译得到的解
     *
     * @param digits
     * @param index
    return res;
     * @param s      保存了此时从digits[0...index-1]翻译得到的一个字母字符串
     */
    private void findCombination(String digits, int index, String s) {

        System.out.println(index + " : " + s);
        if (index == digits.length()) {
            res.add(s);
            System.out.println("get " + s + " , return");
            return;
        }

        Character c = digits.charAt(index);
        if (c.compareTo('0') >= 0 && c.compareTo('9') <= 0 && c.compareTo('1') != 0) {
            String letters = letterMap[c - '0'];
            for (int i = 0; i < letters.length(); i++) {
                System.out.println("digits[" + index + "] = " + c + " , use " + letters.charAt(i));
                findCombination(digits, index + 1, s + letters.charAt(i));
            }
            System.out.println("digits[" + index + "] = " + c + " complete, return");
        }
    }

    private static void printList(List<String> list) {
        System.out.println("最终结果：");
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args) {

        printList((new Solution()).letterCombinations("234"));
    }

}
