package 分类刷题.排序;

/**
 * @author feichaoyu
 */
public class Case1 {
    public static void main(String[] args) {
        int[] arr = {88, 40, 65, 35, 25, 12};
        int max = maxGap(arr);
        System.out.println(max);
    }

    private static int maxGap(int[] arr) {
        int n = arr.length;
        // n+1个桶
        Bucket[] buckets = new Bucket[n + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();

        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        if (min == max) {
            return 0;
        }
        // 将n个数分配到n+1个桶中
        for (int value : arr) {
            int i = bucket(value, n, min, max);
            Bucket bucket = buckets[i];
            bucket.setMin(bucket.isEmpty() ? Math.min(bucket.getMin(), value) : value);
            bucket.setMax(bucket.isEmpty() ? Math.max(bucket.getMax(), value) : value);
            bucket.setEmpty(false);
        }

        // 两个相邻的桶之间判断当前桶最小值减去前一个桶最大值，计算这些值中最大值
        // 注意：第一个桶一定是非空的
        int res = 0;
        int lastMax = buckets[0].getMax();
        int i = 1;
        for (; i <= n; i++) {
            if (!buckets[i].isEmpty()) {
                res = Math.max(res, buckets[i].getMin() - lastMax);
                lastMax = buckets[i].getMax();
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

}

class Bucket {
    private boolean isEmpty;
    private int min;
    private int max;

    public Bucket() {
        isEmpty = true;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
