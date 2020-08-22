package 数据结构.哈希表;

import 数据结构.common.FileOperation;

import java.util.ArrayList;

/**
 * @Author feichaoyu
 * @Date 2019/12/25
 */
public class HashTableTest {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            long startTime = System.nanoTime();

            // Test HashTable
            startTime = System.nanoTime();

            HashTable<String, Integer> ht = new HashTable<>();
            //HashTable<String, Integer> ht = new HashTable<>(131071);
            for (String word : words) {
                if (ht.contains(word)) {
                    ht.set(word, ht.get(word) + 1);
                } else {
                    ht.add(word, 1);
                }
            }

            for (String word : words) {
                ht.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");
        }

        System.out.println();
    }
}
