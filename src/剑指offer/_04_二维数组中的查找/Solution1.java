package 剑指offer._04_二维数组中的查找;

/**
 * Brute Force
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public static boolean findInPartiallySortedMatrix(int[][] data, int target) {

        if (data == null || data.length == 0) {
            return false;
        }

        int m = data.length;
        int n = data[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == target) {
                    return true;
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
