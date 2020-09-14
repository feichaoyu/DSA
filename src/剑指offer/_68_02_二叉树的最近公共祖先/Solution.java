package 剑指offer._68_02_二叉树的最近公共祖先;

public class Solution {

    // 后序遍历dfs
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // root左子树中没有结点p和q，那么一定在root右子树上
        if (left == null) {
            return right;
        }
        // root右子树中没有结点p和q，那么一定在root左子树上
        if (right == null) {
            return left;
        }
        // p和q分别位于root左子树和右子树上，那么root就是它们的公共父结点
        return root;
    }
}
