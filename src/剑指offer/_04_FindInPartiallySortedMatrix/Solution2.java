package 剑指offer._04_FindInPartiallySortedMatrix;

/**
 * 利用每一行每一列都是递增的规律
 *
 * @author feichaoyu
 */
public class Solution2 {

    public static boolean findInPartiallySortedMatrix(int[][] data, int target) {

        if (data == null || data.length == 0) {
            return false;
        }
        int m = data.length;
        int n = data[0].length;

        // 从右上角开始（只能右上角或左下角）
        // 1.相等则Ok
        // 2.小于则跳过这一列
        // 3.大于则跳过这一行
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (target == data[i][j]) {
                    return true;
                } else if (target < data[i][j]) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(findInPartiallySortedMatrix(data, 10));
        System.out.println(findInPartiallySortedMatrix(data, 5));
    }
}

