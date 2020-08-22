package 数据结构.树.二分搜索树;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author feichaoyu
 * @Date 2020/1/1
 */
public class BSTTest {
    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();

        bst.inOrder();
        System.out.println();
        bst.inOrderNR();
        System.out.println();

        bst.postOrder();
        System.out.println();
        bst.postOrderNR();
        System.out.println();

        bst.levelOrder();
        System.out.println();

        System.out.println(bst);

//        BST<Integer> bst = new BST<>();
//        Random random = new Random();
//
//        int n = 1000;
//
//        // test removeMin
//        for(int i = 0 ; i < n ; i ++)
//            bst.add(random.nextInt(10000));
//
//        ArrayList<Integer> nums = new ArrayList<>();
//        while(!bst.isEmpty())
//            nums.add(bst.removeMin());
//
//        System.out.println(nums);
//        for(int i = 1 ; i < nums.size() ; i ++)
//            if(nums.get(i - 1) > nums.get(i))
//                throw new IllegalArgumentException("Error!");
//        System.out.println("removeMin test completed.");
//
//
//        // test removeMax
//        for(int i = 0 ; i < n ; i ++)
//            bst.add(random.nextInt(10000));
//
//        nums = new ArrayList<>();
//        while(!bst.isEmpty())
//            nums.add(bst.removeMax());
//
//        System.out.println(nums);
//        for(int i = 1 ; i < nums.size() ; i ++)
//            if(nums.get(i - 1) < nums.get(i))
//                throw new IllegalArgumentException("Error!");
//        System.out.println("removeMax test completed.");
    }

    // 打乱数组顺序
    private static void shuffle(Object[] arr){

        for(int i = arr.length - 1 ; i >= 0 ; i --){
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }
}
