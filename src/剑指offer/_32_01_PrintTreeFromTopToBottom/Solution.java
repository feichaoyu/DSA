package 剑指offer._32_01_PrintTreeFromTopToBottom;

import java.util.*;

/**
 * @author feichaoyu
 */
public class Solution {

    public int[] levelOrder(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            list.add(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
