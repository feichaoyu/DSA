package 剑指offer._57_01_TwoNumbersWithSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 利用HashMap
 * 时间复杂度O(n)
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(target - num) != null) {
                if (num != target - num) {
                    return new int[]{num, target - num};
                } else {
                    if (map.get(num) > 1) {
                        return new int[]{num, target - num};
                    } else {
                        return new int[]{};
                    }
                }
            }
        }
        return new int[]{};
    }
}
