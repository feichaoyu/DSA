package 剑指offer._39_MoreThanHalfNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用 HashMap 统计
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    // 题目假设nums不为空
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }
}
