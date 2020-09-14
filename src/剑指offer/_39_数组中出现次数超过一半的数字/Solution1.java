package 剑指offer._39_数组中出现次数超过一半的数字;

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
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }
}
