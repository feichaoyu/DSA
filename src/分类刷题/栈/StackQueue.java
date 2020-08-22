package 分类刷题.栈;

import java.util.Stack;

/**
 * 栈实现的队列
 */
public class StackQueue<T> {

    /**
     * 插入栈
     */
    private Stack<T> pushStack = new Stack<>();

    /**
     * 弹出栈
     */
    private Stack<T> popStack = new Stack<>();

    /**
     * 入队
     *
     * @param data
     */
    public void enqueue(T data) {
        pushStack.push(data);
    }

    /**
     * 出队
     * 这里分两种情况：
     * 1.popStack不为空，可以直接弹出数据
     * 2.popStack为空，需要先弹出pushStack的数据，依次放入popStack中，然后再弹出popStack的数据
     *
     * @return
     */
    public T dequeue() {
        // 第一种情况
        if (!popStack.empty()) {
            return popStack.pop();
        }
        // 第二种情况，不过还需要判断 pushStack 是否为空，为空就说明没有元素了
        else if (!pushStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
            return popStack.pop();
        }
        return null;
    }

    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println("出队元素：" + queue.dequeue());
        System.out.println("出队元素：" + queue.dequeue());
        System.out.println("出队元素：" + queue.dequeue());
    }
}
