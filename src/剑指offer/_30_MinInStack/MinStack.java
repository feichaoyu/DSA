package 剑指offer._30_MinInStack;

import java.util.Queue;
import java.util.Stack;

/**
 * @author feichaoyu
 */
public class MinStack {

    private int min;

    private Stack<Integer> stack;

    private Stack<Integer> minStack;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (x < min) {
            min = x;
        }
        // 1.如果入栈元素 x 大于等于 min，则 minStack 压入 min 自身
        // 2.如果入栈元素 x 小于 min，则 minStack 压入 x
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : min();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.minStack);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.minStack);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.minStack);
        System.out.println(stack.min());
    }
}
