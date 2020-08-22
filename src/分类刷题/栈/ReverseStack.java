package 分类刷题.栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 翻转栈中元素
 */
public class ReverseStack {

    public static void main(String[] args) {

        method1();

        method2();
    }

    /**
     * 方法一：申请额外的一个队列，先把栈中元素出栈放入队列中，然后再把队列中的元素依次出队放入栈中
     * 不过空间复杂度就高了
     */
    public static void method1() {

        Stack<Integer> stack = new Stack<>();
        int[] arr = {5, 4, 3, 2, 1};
        for (int e : arr) {
            stack.push(e);
        }
        System.out.println("翻转前：" + stack);

        Queue<Integer> queue = new LinkedList<>();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            queue.add(stack.pop());
        }

        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            stack.push(queue.remove());
        }

        System.out.println("翻转后：" + stack);
    }

    /**
     * 方法二：递归。
     * 将当前栈的最底元素移到栈顶，其他元素顺次下移一位，然后对不包含栈顶元素的子栈进行同样的操作，直到栈为空。
     * 同时，栈的最底元素移到栈顶也需要用到递归。
     */
    public static void method2() {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {5, 4, 3, 2, 1};
        for (int e : arr) {
            stack.push(e);
        }
        System.out.println("翻转前：" + stack);

        reverseStack(stack);

        System.out.println("翻转后：" + stack);
    }

    /**
     * 把栈底元素移动到栈顶
     *
     * @param s
     */
    private static void moveBottomToTop(Stack<Integer> s) {
        if (s.empty()) {
            return;
        }

        // 得到栈顶元素
        int top1 = s.peek();
        // 得到子栈
        s.pop();
        // 子栈不为空则递归
        if (!s.empty()) {
            // 递归处理不包含栈顶元素的子栈
            moveBottomToTop(s);
            // 得到子栈栈顶元素
            int top2 = s.peek();

            s.pop();
            // 交换栈顶元素和子栈栈顶元素
            s.push(top1);
            s.push(top2);
        } else {
            s.push(top1);
        }
    }

    private static void reverseStack(Stack<Integer> s) {
        if (s.empty()) {
            return;
        }

        // 1.把栈底元素移动到栈顶
        moveBottomToTop(s);
        int top = s.peek();
        s.pop();
        // 2.递归处理子栈
        reverseStack(s);
        s.push(top);
    }
}
