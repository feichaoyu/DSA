package 剑指offer._55_01_TreeDepth;

import java.util.LinkedList;
import java.util.List;

/**
 * 层序遍历
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<TreeNode> queue = new LinkedList<>();
        List<TreeNode> tmp;
        int res = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
