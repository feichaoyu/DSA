package 剑指offer._28_对称的二叉树;

/**
 * @author feichaoyu
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode L, TreeNode R) {

        // 当 L 和 R 同时越过叶节点，此树从顶至底的节点都对称，返回 true
        if (L == null && R == null) {
            return true;
        }
        // 当 L 或 R 中只有一个越过叶节点，或者 L 的值不等于 R 的值，此树不对称，返回 false
        if (L == null || R == null || L.val != R.val) {
            return false;
        }

        return isSymmetric(L.left, R.right) && isSymmetric(L.right, R.left);
    }

}
