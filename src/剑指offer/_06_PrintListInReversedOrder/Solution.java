package 剑指offer._06_PrintListInReversedOrder;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Stack;

/**
 * @author feichaoyu
 */
public class Solution {

    // 递归
    public static void printReversinglyRecursively(ListNode<Integer> node) {

        if (node == null) {
            return;
        }

        // 每当访问一个节点，先递归输出后面的节点，再输出该节点本身
        printReversinglyRecursively(node.next);
        System.out.print(node.val);
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
        printReversinglyRecursively(head);
        System.out.println();
        printReversinglyIteratively(head);
    }
}
