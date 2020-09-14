package 考试;

import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isValid(s)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                }

                Character c = stack.pop();
                char match = 0;
                if (s.charAt(i) == ')') {
                    match = '(';
                } else if (s.charAt(i) == '}') {
                    match = '{';
                } else if (s.charAt(i) == ']') {
                    match = '[';
                }

                if (!c.equals(match)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
