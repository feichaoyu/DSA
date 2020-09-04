package 分类刷题.树.二叉树中的最大路径和;

public class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求左子树的最大和，至少为0，杜绝了负数的情况，换句话说，出现负数的分支我们就不考虑了
        int left = Math.max(0, dfs(root.left));
        // 求右子树的最大和，至少为0，杜绝了负数的情况，换句话说，出现负数的分支我们就不考虑了
        int right = Math.max(0, dfs(root.right));

        // 当前子树的 maxSum 挑战最大值
        maxSum = Math.max(maxSum, left + root.val + right);

        // 向父节点提供的最大和，要包括自己
        return root.val + Math.max(left, right);
    }
}
