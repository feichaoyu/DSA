package 练习题.栈;

import java.util.Stack;

/**
 * 根据入栈序列判断可能的出栈序列（序列是String类型）
 */
public class Case1 {

    public static void main(String[] args) {
        String push = "12345";
        String pop = "32541";
        if (isPopSerial(push, pop)) {
            System.out.println(pop + "是" + push + "的一个pop序列");
        } else {
            System.out.println(pop + "不是" + push + "的一个pop序列");
        }
    }

    /**
     * 思路：
     * 1.把push序列依次入栈，直到栈顶元素等于pop序列中第一个元素，然后栈顶元素出栈，pop序列移动到下一个元素
     * 2.如果栈顶元素继续等于pop序列现在的元素，则继续出栈且pop后移，否则把push序列继续入栈
     * 3.如果栈为空，并且pop序列中的元素全部被遍历过，则表示pop序列是一个可能的出栈序列
     *
     * @param push 入栈序列
     * @param pop  出栈序列
     * @return
     */
    private static boolean isPopSerial(String push, String pop) {
        if (push == null || pop == null) {
            return false;
        }
        int pushLen = push.length();
        int popLen = pop.length();
        // 序列长度不一致，则不可能
        if (pushLen != popLen) {
            return false;
        }

        int pushIndex = 0;
        int popIndex = 0;
        Stack<Character> stack = new Stack<>();
        while (pushIndex < pushLen) {
            // push序列依次入栈
            stack.push(push.charAt(pushIndex));
            pushIndex++;
            // 栈顶元素等于pop序列中第一个元素
            while (!stack.empty() && stack.peek() == pop.charAt(popIndex)) {
                // 栈顶元素出栈，pop序列移动到下一个元素
                stack.pop();
                popIndex++;
            }
        }
        // 栈为空，并且pop序列中的元素全部被遍历过，则返回true
        return stack.empty() && popIndex == popLen;
    }
}
