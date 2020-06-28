package 剑指offer._55_02_BalancedBinaryTree;

/**
 * 前序遍历
 *
 * @author feichaoyu
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(root);
        // 左右子树高度差大于1则不是
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getBalanceFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 求左子树和右子树中最大的高度加上根节点的高度1就是树的高度
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
