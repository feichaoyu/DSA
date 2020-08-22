package 剑指offer._45_SortArrayForMinNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通过在排序时传入一个自定义的 Comparator 实现，重新定义 String 列表内的排序方法，
 * 若拼接 s1 + s2 > s2 + s1，那么显然应该把 s2 在拼接时放在前面，以此类推，将整个 String 列表排序后再拼接起来。
 *
 * @author feichaoyu
 */
public class Solution {

    public String minNumber(int[] nums) {

        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();

        // lambda
//        return Arrays.stream(nums)
//                .boxed()
//                .map(String::valueOf)
//                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
//                .collect(Collectors.joining());
    }
}
