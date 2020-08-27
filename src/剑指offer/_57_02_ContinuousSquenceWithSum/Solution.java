package 剑指offer._57_02_ContinuousSquenceWithSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        while (left <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += right;
                right++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= left;
                left++;
            } else {
                // 保存结果
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= left;
                left++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
