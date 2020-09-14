package 考试.珍爱网;

public class Solution1 {

    public boolean parking(int[] park, int n) {
        if (park.length < n) {
            return false;
        }

        for (int i = 0; i < park.length; i++) {
            for (int j = i + 1; j < park.length; j++) {
                if (park[j] == park[i] && park[j] == 0) {
                    n--;
                } else {
                    break;
                }
            }
        }
        if (n > 0) {
            return false;
        }
        return true;
    }
}
