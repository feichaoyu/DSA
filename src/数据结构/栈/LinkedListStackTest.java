package 数据结构.栈;

/**
 * @Author feichaoyu
 * @Date 2019/12/26
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
