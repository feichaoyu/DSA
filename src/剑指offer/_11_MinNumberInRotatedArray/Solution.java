package 剑指offer._11_MinNumberInRotatedArray;

/**
 * @author feichaoyu
 */
public class Solution {

    public static int minArray(int[] numbers) {

        return getMin(numbers, 0, numbers.length - 1);
    }

    private static int getMin(int[] numbers, int left, int right) {

        if (left == right) {
            return numbers[left];
        }

        int mid = left + (right - left) / 2;
        if (numbers[mid] > numbers[right]) {
            return getMin(numbers, mid + 1, right);
        } else if (numbers[mid] == numbers[right]) {
            return getMin(numbers, left, right - 1);
        } else {
            return getMin(numbers, left, mid);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println(minArray(arr1));
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(minArray(arr2));
        int[] arr3 = {1, 1, 1, 1, 1};
        System.out.println(minArray(arr3));
        int[] arr4 = {1, 0, 1, 1, 1};
        System.out.println(minArray(arr4));
    }
}
