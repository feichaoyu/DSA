package 考试.达达;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = Integer.parseInt(sc.nextLine());
        int count = Integer.parseInt(sc.nextLine()) + 1;

        List<int[]> list = new ArrayList<>();
        int[] target = new int[0];
        for (int i = 0; i < count; i++) {
            String[] strings = sc.nextLine().trim().split(",");
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(strings[0]);
            temp[1] = Integer.parseInt(strings[1]);
            if (i == count - 1) {
                target = temp;
            } else {
                list.add(temp);
            }
        }
        List<int[]> result = helper(list, target, type);
        for (int i = 0; i < result.size(); i++) {
            int[] temp = result.get(i);
            System.out.println(temp[0] + "," + temp[1]);
        }


    }

    public static List<int[]> helper(List<int[]> list, int[] target, int type) {
        List<int[]> result = new ArrayList<>();
        if (type == 1) {
            for (int i = 0; i < list.size(); i++) {
                int[] temp = list.get(i);
                if (temp[0] >= target[0] && temp[1] <= target[1]) {
                    result.add(temp);
                }
            }
        } else if (type == 2) {
            for (int i = 0; i < list.size(); i++) {
                int[] temp = list.get(i);
                if (temp[0] >= target[0] && temp[0] <= target[1] || target[0] <= temp[1] && target[1] >= temp[1]) {
                    result.add(temp);
                }
            }
        }

        return result;
    }
}
