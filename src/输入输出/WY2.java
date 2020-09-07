package 输入输出;

import java.util.*;

public class WY2 {

    /**
     * 3
     * 10
     * 0 1
     * 0 -1
     * 1 1
     * 1 1
     * 1 -1
     * 0 1
     * 2 1
     * 2 -1
     * 3 1
     * 3 1
     * 2
     * 3 1
     * 3 1
     * 8
     * 0 1
     * 0 1
     * 3 1
     * 3 1
     * 1 1
     * 1 1
     * 2 1
     * 0 1
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<List<Integer>> data = new ArrayList<>(t);
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>(2 * n);
            for (int j = 0; j < 2 * n; j++) {
                list.add(sc.nextInt());
            }
            data.add(list);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            List<Integer> path = data.get(i);
            for (int j = 0; j < path.size(); j += 2) {
                if (path.get(j) == 0 && path.get(j + 1) == 1) {
                    map.put(0, map.getOrDefault(0, 0) + 1);
                } else if (path.get(j) == 1 && path.get(j + 1) == 1) {
                    map.put(1, map.getOrDefault(1, 0) + 1);
                } else if (path.get(j) == 2 && path.get(j + 1) == 1) {
                    map.put(2, map.getOrDefault(2, 0) + 1);
                } else if (path.get(j) == 3 && path.get(j + 1) == 1) {
                    map.put(3, map.getOrDefault(3, 0) + 1);
                }
            }

            System.out.println(Math.abs(map.getOrDefault(0, 0) - map.getOrDefault(1, 0)) +
                    Math.abs(map.getOrDefault(2, 0) - map.getOrDefault(3, 0)));

            map.clear();
        }

    }
}
