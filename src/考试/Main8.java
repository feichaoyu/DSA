package 考试;

import java.util.*;

public class Main8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();

        Set<String> set = new HashSet<>();
        if (isCross(set, chars)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }

    public static boolean isCross(Set<String> set, char[] chars) {
        int i = 0, j = 0;
        String tmp = i + "," + j;
        set.add(tmp);

        for (char c : chars) {
            switch (c) {
                case 'N':
                    ++j;
                    break;
                case 'S':
                    --j;
                    break;
                case 'E':
                    ++i;
                    break;
                case 'W':
                    --i;
                    break;
            }
            String t = i + "," + j;
            if (set.contains(t)) {
                return true;
            } else {
                set.add(t);
            }
        }
        return false;
    }
}
