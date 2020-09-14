package 考试;

public class Main23 {

    public static void main(String[] args) {

        int n = 1;
        int k = 1;
        String s = dfs(n);
        System.out.println(s.charAt(k - 1));
    }

    public static String dfs(int n) {
        if (n == 1) {
            return "0";
        }
        String s = dfs(n - 1);
        return s + "1" + reverse(invert(s));
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static String invert(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                sb.replace(i, i + 1, "0");
            } else {
                sb.replace(i, i + 1, "1");
            }
        }
        return sb.toString();
    }
}
