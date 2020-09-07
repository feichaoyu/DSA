package 输入输出;

import java.util.*;

public class WY1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            if (!set.contains(id)) {
                set.add(id);
                Integer value = map.getOrDefault(name, 1);
                if (value == 1) {
                    value++;
                    count++;
                }
                map.put(name, value);
            }
        }
        System.out.println(count);
    }
}
