package 剑指offer._34_PathInTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author feichaoyu
 */
public class Solution {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<Integer> path = new LinkedList<>();
        findRoad(root, sum, path);
        return res;
    }

    private void findRoad(TreeNode root, int target, List<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.val);
        // 每次target减去当前节点的值，直到为0
        // 这里为什么用减法，因为如果用加法求和是否等于给定值，需要多一个传参
        target -= root.val;

        // 当前结点是叶子结点且target减为0，表明找到一条路径
        if (target == 0 && root.left == null && root.right == null) {
            // 这里需要注意：不能直接传入path，应该 new LinkedList<>(path)，因为path全局只有一个，不能影响下一次
            res.add(new LinkedList<>(path));
        }

        // 遍历root的左子树
        findRoad(root.left, target, path);

        // 遍历root的右子树
        findRoad(root.right, target, path);

        // 向上清除遍历的路径
        path.remove(path.size() - 1);
    }
}
