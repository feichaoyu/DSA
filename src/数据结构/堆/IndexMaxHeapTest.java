package 数据结构.堆;

import java.util.Random;

/**
 * @author feichaoyu
 */
public class IndexMaxHeapTest {
    private static double testHeap(Integer[] testData) {

        long startTime = System.nanoTime();

        IndexMaxHeap<Integer> heap;

        heap = new IndexMaxHeap<>();
        for (int i = 0; i < testData.length; i++) {
            heap.add(i, testData[i]);
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = heap.extractMax();
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time = testHeap(testData);
        System.out.println(time + " s");
    }
}
