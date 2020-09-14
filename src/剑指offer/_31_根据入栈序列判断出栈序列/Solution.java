package 剑指offer._31_根据入栈序列判断出栈序列;

import java.util.Stack;

/**
 * @author feichaoyu
 */
public class Solution {

    /**
     * 思路：
     * 1.把push序列依次入栈，直到栈顶元素等于pop序列中第一个元素，然后栈顶元素出栈，pop序列移动到下一个元素
     * 2.如果栈顶元素继续等于pop序列现在的元素，则继续出栈且pop后移，否则把push序列继续入栈
     * 3.如果栈为空，并且pop序列中的元素全部被遍历过，则表示pop序列是一个可能的出栈序列
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed == null || popped == null) {
            return false;
        }

        int pushLen = pushed.length;
        int popLen = popped.length;
        // 序列长度不一致，则不可能
        if (pushLen != popLen) {
            return false;
        }

        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (pushIndex < pushLen) {
            // push序列依次入栈
            stack.push(pushed[pushIndex]);
            pushIndex++;
            // 栈顶元素等于pop序列中第一个元素
            while (!stack.empty() && stack.peek() == popped[popIndex]) {
                // 栈顶元素出栈，pop序列移动到下一个元素
                stack.pop();
                popIndex++;
            }
        }
        // 栈为空，并且pop序列中的元素全部被遍历过，则返回true
        return stack.empty() && popIndex == popLen;
    }
}
