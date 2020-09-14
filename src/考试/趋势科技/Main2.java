package 考试.趋势科技;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        String inorderStr = split[0];
        String postorderStr = split[1];
        preOrder(postorderStr, inorderStr, inorderStr.length());
    }

    private static void preOrder(String postOrder, String inOrder, int length) {
        if (length == 1) {
            System.out.println(inOrder);
            return;
        }
        if (length == 0) {
            return;
        }

        int index = findPosInOrder(postOrder, inOrder, postOrder.length() - 1);
        String inOrderLeft = inOrder.substring(0, index);
        String inOrderRight = inOrder.substring(index + 1);

        String postOrderLeft = postOrder.substring(0, index);
        String postOrderRight = postOrder.substring(index + 1, postOrder.length() - 1);

        System.out.println(postOrder.charAt(postOrder.length() - 1));
        preOrder(postOrderLeft, inOrderLeft, inOrderLeft.length());
        preOrder(postOrderRight, inOrderRight, inOrderRight.length());
    }

    private static int findPosInOrder(String str, String input, int position) {
        char c = str.charAt(position);
        int length = input.length();
        for (int i = 0; i < length; i++) {
            if (c == input.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
