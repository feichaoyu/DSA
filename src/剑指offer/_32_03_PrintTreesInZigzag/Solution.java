package 剑指offer._32_03_PrintTreesInZigzag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 利用双端队列
 * @author feichaoyu
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            // 这里需要用到双端队列
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.remove();
                if (res.size() % 2 == 0) {
                    // 偶数层(从0开始) -> 队列尾部
                    tmp.addLast(cur.val);
                } else {
                    // 奇数层 -> 队列头部
                    tmp.addFirst(cur.val);
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }

            }
            res.add(tmp);
        }
        return res;
    }
}
