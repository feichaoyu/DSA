package 分类刷题.深度优先搜索;

public class Solution2 {

    public static void main(String[] args) {
        for (int n = Integer.MIN_VALUE; n < Integer.MAX_VALUE; n++) {

            int count = 0;
            int count2 = 0;
            int flag = 1;
            while (flag != 0) {
                if ((n & flag) != 0) {
                    count++;
                }
                flag = flag << 1;
            }

            String s = Integer.toBinaryString(n);
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    count2++;
                }
            }
//            System.out.println(n);
            if (count != count2) {
                System.out.println(n);
                break;
            }
        }

    }
}
