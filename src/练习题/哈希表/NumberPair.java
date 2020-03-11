package 练习题.哈希表;

import java.util.HashMap;

/**
 * 给定一个数组，找出数组中是否存在两个数对(a,b)和(c,d)，使得a+b=c+d，其中a,b,c,d是不同的元素
 * 如果有多个答案，打印任意一个即可
 */
public class NumberPair {

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 10, 20, 9, 8};
        findPairs(arr);
    }

    /**
     * 利用哈希表找寻数对，键为数对的和，值为数对
     *
     * @param arr
     * @return true indicate find
     */
    private static boolean findPairs(int[] arr) {
        HashMap<Integer, Pair> sumPair = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (!sumPair.containsKey(sum)) {
                    sumPair.put(sum, new Pair(i, j));
                } else {
                    // 已经存在相同数对，直接打印
                    Pair p = sumPair.get(sum);
                    System.out.println("(" + arr[p.first] + "," + arr[p.second] + "), (" + arr[i] + "," + arr[j] + ")");
                    return true;
                }
            }
        }
        return false;
    }
}

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
