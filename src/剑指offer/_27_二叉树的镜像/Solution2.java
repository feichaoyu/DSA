package 剑指offer._27_二叉树的镜像;

import java.util.Stack;

/**
 * 迭代法(前序遍历)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            // 交换左右节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
