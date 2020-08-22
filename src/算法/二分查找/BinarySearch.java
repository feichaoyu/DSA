package 算法.二分查找;

/**
 * @author feichaoyu
 */
public class BinarySearch {

    public static <T extends Comparable<T>> int binarySearch(T[] arr, int n, T target) {

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target.compareTo(arr[mid]) > 0) {
                // target在[mid+1...r]中
                l = mid + 1;
            } else {
                // target在[l...mid-1]中
                r = mid - 1;
            }
        }
        // 没找到
        return -1;
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 3, 5, 7, 9};
        System.out.println(binarySearch(arr, arr.length, 7));
    }
}
