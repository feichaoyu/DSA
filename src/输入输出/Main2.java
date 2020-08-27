package 输入输出;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][2];
        int i = 0;
        while (i < n) {
            arr[i][0] = i + 1;
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[i][1] = v + 2 * w;
            i++;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[] ans = new int[m];
        for (int j = 0; j < m; j++) {
            ans[j] = arr[j][0];
        }
        Arrays.sort(ans);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < m; k++) {
            sb.append(ans[k] + " ");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
