package 数据结构.树.AVL;

import 数据结构.common.FileOperation;

import java.util.ArrayList;

/**
 * @Author feichaoyu
 * @Date 2020/1/9
 */
public class AVLTreeTest {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());
            for(String word: words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced()) {
                    throw new RuntimeException();
                }
            }
        }

        System.out.println();
    }
}
