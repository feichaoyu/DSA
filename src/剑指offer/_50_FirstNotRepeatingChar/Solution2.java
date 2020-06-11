package 剑指offer._50_FirstNotRepeatingChar;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap优化
 *
 * @author feichaoyu
 */
public class Solution2 {

    public char firstUniqChar(String s) {

        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) {
                return d.getKey();
            }
        }
        return ' ';
    }
}
