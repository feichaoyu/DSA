package 剑指offer._27_二叉树的镜像;

/**
 * 递归法
 *
 * @author feichaoyu
 */
public class Solution1 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);
        // 交换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
