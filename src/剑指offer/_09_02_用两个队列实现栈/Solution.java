package 剑指offer._09_02_用两个队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现一个栈
 *
 * @author feichaoyu
 */
public class Solution {
    public static void main(String[] args) {
        QueueStack<Integer> stack = new QueueStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("弹出元素：" + stack.pop());
        System.out.println("弹出元素：" + stack.pop());
        System.out.println("弹出元素：" + stack.pop());
    }
}

class QueueStack<T> {

    private final Queue<T> queue1 = new LinkedList<>();

    private final Queue<T> queue2 = new LinkedList<>();

    public void push(T data) {
        if (!queue1.isEmpty()) {
            queue1.add(data);
        } else {
            queue2.add(data);
        }
    }

    public T pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }
        return null;
    }
}
