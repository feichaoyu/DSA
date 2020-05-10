package 剑指offer._06_PrintListInReversedOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author feichaoyu
 */
public class Solution {

    private static List<Integer> list = new ArrayList<>();

    // 递归
    public static int[] reversePrint(ListNode<Integer> head) {
        printReversinglyRecursively(head);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static void printReversinglyRecursively(ListNode<Integer> node) {
        if (node == null) {
            return;
        }

        // 每当访问一个节点，先递归输出后面的节点，再输出该节点本身
        printReversinglyRecursively(node.next);
        list.add(node.val);
    }

    // 非递归，用栈模拟递归
    public static void printReversinglyIteratively(ListNode<Integer> node) {

        if (node == null) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode<Integer> temp = node;
        while (temp != null) {
            stack.add(temp.val);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        int[] res = reversePrint(head);
        System.out.println(Arrays.toString(res));
    }
}
