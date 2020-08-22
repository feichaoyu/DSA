package 剑指offer._55_01_TreeDepth;

/**
 * 后序遍历
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int maxDepth(TreeNode root) {

        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 求左子树和右子树中最大的高度加上根节点的高度1就是树的最大高度
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
