package 剑指offer._32_02_PrintTreesInLines;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 和上一题相比，这题要求每一行单独打印到一个数组或List集合中
 *
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
            List<Integer> tmp = new ArrayList<>();
            // 队列的长度就是每一层的需要循环的次数
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.remove();
                tmp.add(cur.val);
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
