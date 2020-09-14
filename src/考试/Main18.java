package 考试;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main18 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _boxes_rows = 0;
        int _boxes_cols = 0;
        _boxes_rows = Integer.parseInt(in.nextLine().trim());
        _boxes_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _boxes = new int[_boxes_rows][_boxes_cols];
        for (int _boxes_i = 0; _boxes_i < _boxes_rows; _boxes_i++) {
            for (int _boxes_j = 0; _boxes_j < _boxes_cols; _boxes_j++) {
                _boxes[_boxes_i][_boxes_j] = in.nextInt();

            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        res = maxBoxes(_boxes);
        System.out.println(res);

    }

    static int maxBoxes(int[][] boxes) {
        Box[] box = getSortedBoxes(boxes);
        int[] ends = new int[boxes.length];
        ends[0] = box[0].wid;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < box.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = l + (r - l) / 2;
                if (box[i].wid > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = box[i].wid;
        }
        return right + 1;
    }

    static Box[] getSortedBoxes(int[][] boxes) {
        Box[] res = new Box[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            res[i] = new Box(boxes[i][0], boxes[i][1]);
        }
        Arrays.sort(res, new BoxComparator());
        return res;
    }

    static class BoxComparator implements Comparator<Box> {

        @Override
        public int compare(Box o1, Box o2) {
            return o1.len != o2.len ? o1.len - o2.len : o2.wid - o1.wid;
        }
    }
}

class Box {
    public int len;
    public int wid;

    public Box(int len, int wid) {
        this.len = len;
        this.wid = wid;
    }
}
