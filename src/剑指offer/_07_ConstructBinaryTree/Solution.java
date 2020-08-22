package 剑指offer._07_ConstructBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feichaoyu
 */
public class Solution {

    public static TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return constructCore(preorder, 0, inorder, 0, preorder.length);
    }

    public static TreeNode<Integer> constructCore(int[] preorder, int preorderStart, int[] inorder, int inorderStart, int length) {

        if (length == 0) {
            return null;
        }

        int inorderIndex = -1;
        for (int i = inorderStart; i < inorderStart + length; i++) {
            if (inorder[i] == preorder[preorderStart]) {
                inorderIndex = i;
                break;
            }
        }
        int leftLength = inorderIndex - inorderStart;
        int rightLength = length - leftLength - 1;
        TreeNode<Integer> node = new TreeNode<>(preorder[preorderStart]);
        node.left = constructCore(preorder, preorderStart + 1, inorder, inorderStart, leftLength);
        node.right = constructCore(preorder, preorderStart + leftLength + 1, inorder, inorderIndex + 1, rightLength);
        return node;
    }

    // 前序遍历递归版
    public static List<Integer> preorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.add(node.val);
        list.addAll(preorderRecursively(node.left));
        list.addAll(preorderRecursively(node.right));
        return list;
    }

    // 中序遍历递归版
    public static List<Integer> inorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.addAll(inorderRecursively(node.left));
        list.add(node.val);
        list.addAll(inorderRecursively(node.right));
        return list;
    }

    // 后序遍历递归版
    public static List<Integer> postorderRecursively(TreeNode<Integer> node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.addAll(postorderRecursively(node.left));
        list.addAll(postorderRecursively(node.right));
        list.add(node.val);
        return list;
    }

    public static void main(String[] args) {

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode<Integer> root = buildTree(pre, in);
        // 对重建后的树，进行前中后序遍历，验证是否正确
        List<Integer> preorder = preorderRecursively(root);
        List<Integer> inorder = inorderRecursively(root);
        List<Integer> postorder = postorderRecursively(root);
        System.out.println("preorder:" + preorder);
        System.out.println("inorder:" + inorder);
        System.out.println("postorder:" + postorder);
    }
}
