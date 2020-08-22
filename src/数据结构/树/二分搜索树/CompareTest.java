package 数据结构.树.二分搜索树;

import 数据结构.common.FileOperation;
import 数据结构.映射Map.BSTMap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author feichaoyu
 */
public class CompareTest {
    // 比较BST和SST的性能，BST性能明显优于SST
    public static void main(String[] args) {

        // 我们使用文本量更小的共产主义宣言进行试验:)
        String filename = "communist.txt";
        ArrayList<String> words = new ArrayList<String>();

        if (FileOperation.readFile(filename, words)) {

            System.out.println("There are totally " + words.size() + " words in " + filename);
            System.out.println();

            // 测试1: 我们按照文本原有顺序插入进二分搜索树
            long startTime = System.currentTimeMillis();
            BSTMap<String, Integer> bst = new BSTMap<>();
            for (String word : words) {
                Integer res = bst.get(word);
                if (res == null) {
                    bst.add(word, 1);
                } else {
                    bst.add(word, res + 1);
                }
            }

            // 我们查看unite一词的词频
            if (bst.contains("unite")) {
                System.out.println("'unite' : " + bst.get("unite"));
            } else {
                System.out.println("No word 'unite' in " + filename);
            }

            long endTime = System.currentTimeMillis();

            System.out.println("BST , time: " + (endTime - startTime) + "ms.");
            System.out.println();

            // 测试2: 我们按照文本原有顺序插入顺序查找表
            startTime = System.currentTimeMillis();
            SST<String, Integer> sst = new SST<String, Integer>();
            for (String word : words) {
                Integer res = sst.search(word);
                if (res == null) {
                    sst.insert(word, 1);
                } else {
                    sst.insert(word, res + 1);
                }
            }

            // 我们查看unite一词的词频
            if (sst.contain("unite")) {
                System.out.println("'unite' : " + sst.search("unite"));
            } else {
                System.out.println("No word 'unite' in " + filename);
            }

            endTime = System.currentTimeMillis();
            System.out.println("SST , time: " + (endTime - startTime) + "ms.");
            System.out.println();

            // 测试3: 我们将原文本排序后插入二分搜索树, 查看其效率
            startTime = System.currentTimeMillis();
            BSTMap<String, Integer> bst2 = new BSTMap<>();
            Collections.sort(words);
            for (String word : words) {
                Integer res = bst2.get(word);
                if (res == null) {
                    bst2.add(word, new Integer(1));
                } else {
                    bst2.add(word, res + 1);
                }
            }

            // 我们查看unite一词的词频
            if (bst.contains("unite")) {
                System.out.println("'unite' : " + bst2.get("unite"));
            } else {
                System.out.println("No word 'unite' in " + filename);
            }

            endTime = System.currentTimeMillis();
            System.out.println("BST2 , time: " + (endTime - startTime) + "ms.");
        }
    }
}
