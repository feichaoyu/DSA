package 剑指offer._03_01_DuplicationInArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 利用哈希表
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 *
 * @author feichaoyu
 */
public class Solution3 {

    public static int getDuplication(int[] data) {

        // 输入空指针
        if (data == null || data.length < 2) {
            return -1;
        }

        // 输入数据范围无效
        for (int datum : data) {
            if (datum < 0 || datum > data.length - 1) {
                return -1;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int e : data) {
            if (set.contains(e)) {
                return e;
            } else {
                set.add(e);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("操作前数组" + Arrays.toString(data));
        System.out.println(getDuplication(data));
        System.out.println("操作后数组" + Arrays.toString(data));

        int[] data2 = {2, 3, 1, 0, 6, 5, 4};
        System.out.println(getDuplication(data2));
    }
}
