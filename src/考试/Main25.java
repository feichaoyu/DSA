package 考试;

public class Main25 {

    public int combination(int r, int n) {
        int z = 1;
        if (r <= 0 || n <= 0 || n < r) {
            return 0;
        }
        return jieChen(n) / (jieChen(n - r) * jieChen(r));
    }

    public int jieChen(int n) {
        int result = 1;
        if (n < 0 || n > 19) {
            return -1;
        }
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
