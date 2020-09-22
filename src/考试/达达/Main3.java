package 考试.达达;

import java.util.*;

// 基于权重的随机数生成器
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] split = s.split(",");
            map.put(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
        WeightRandom<Integer, Integer> weightRandom = new WeightRandom<>(map);
        for (int i = 0; i < 10; i++) {
            System.out.println(weightRandom.random());
        }
    }
}

class WeightRandom<K, V extends Number> {
    private TreeMap<Double, K> weightMap = new TreeMap<>();

    public WeightRandom(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey().doubleValue();
            this.weightMap.put(entry.getValue().doubleValue() + lastWeight, entry.getKey());
        }
    }

    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }
}
