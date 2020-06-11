package 剑指offer._50_FirstNotRepeatingChar;

import java.util.HashMap;

/**
 * HashMap
 *
 * @author feichaoyu
 */
public class Solution1 {

    public char firstUniqChar(String s) {

        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : sc) {
            if (dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
