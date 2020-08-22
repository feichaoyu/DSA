package 数据结构.树.红黑树;

import 数据结构.树.AVL.AVLTree;

import java.util.ArrayList;

/**
 * @Author feichaoyu
 * @Date 2020/1/9
 */
public class SortedCompareTest {
    public static void main(String[] args) {

        int n = 20000000;

        // just for AVLTree and RBTree
        ArrayList<Integer> testData = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            testData.add(i);
        }

        // Test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData) {
            avl.add(x, null);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");

        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for (Integer x : testData) {
            rbt.add(x, null);
        }

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");
    }
}
