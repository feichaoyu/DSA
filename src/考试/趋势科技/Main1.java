package 考试.趋势科技;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

    private static int postIndex;
    private static char[] inorder;
    private static char[] postorder;
    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        String inorderStr = split[0];
        String postorderStr = split[1];

        inorder = inorderStr.toCharArray();

        postorder = postorderStr.toCharArray();

        preOrder(buildTree());

    }

    public static TreeNode buildTree() {
        postIndex = postorder.length - 1;
        int index = 0;
        for (char val : inorder) {
            map.put(val, index++);
        }
        return helper(0, inorder.length - 1);
    }

    private static TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        char val = postorder[postIndex];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        postIndex--;
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);

        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
