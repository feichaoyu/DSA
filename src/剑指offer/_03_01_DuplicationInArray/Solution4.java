package 剑指offer._03_01_DuplicationInArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 将数组按下标转移到新数组（类似哈希表的思想）
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 *
 * @author feichaoyu
 */
public class Solution4 {

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

        int[] copyData = new int[data.length];
        Arrays.fill(copyData, -1);
        for (int e : data) {
            if (copyData[e] == e) {
                return e;
            } else {
                copyData[e] = e;
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
