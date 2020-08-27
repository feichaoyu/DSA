package 输入输出;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        int[] arr = new int[n];

        // 物品的重量
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }

        // 获取的排列
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            map.put(e, e);
        }

        int max;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < map.size(); j++) {
                if (map.get(j) < arr[i]) {
                    left.add(w[j - 1]);
                } else if (map.get(j) > arr[i]) {
                    right.add(w[j - 1]);
                }
            }
            map.remove(arr[i]);
            max = Math.max(left.stream().mapToInt(e -> e).sum(), right.stream().mapToInt(e -> e).sum());
            System.out.println(max);
            left.clear();
            right.clear();
        }
    }
}
