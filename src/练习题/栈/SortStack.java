package 练习题.栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 排序栈中元素
 */
public class SortStack {

    public static void main(String[] args) {

        method();
    }

    /**
     * 排序思路和之前的翻转是差不多的。
     * 首先对不包含栈顶元素的子栈排序，如果栈顶元素大于子栈的栈顶元素，则交换这两个元素。
     */
    public static void method() {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {5, 2, 4, 1, 3};
        for (int e : arr) {
            stack.push(e);
        }
        System.out.println("排序前：" + stack);

        sortStack(stack);

        System.out.println("排序后：" + stack);
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

            if (top1 > top2) {
                s.pop();
                // 交换栈顶元素和子栈栈顶元素
                s.push(top1);
                s.push(top2);
                return;
            }
        }
        s.push(top1);

    }

    private static void sortStack(Stack<Integer> s) {
        if (s.empty()) {
            return;
        }

        // 1.把栈底元素移动到栈顶
        moveBottomToTop(s);
        int top = s.peek();
        s.pop();
        // 2.递归处理子栈
        sortStack(s);
        s.push(top);
    }
}
