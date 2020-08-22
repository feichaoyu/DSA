package 剑指offer._37_SerializeBinaryTrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 其实可以通过前中后遍历，也可以通过层序遍历。因为题目示例给了层序遍历，这里就用层序遍历了
 *
 * @author feichaoyu
 */
public class Solution {

    // 用List存储
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == null) {
                list.add(null);
                continue;
            } else {
                list.add(cur.val);
            }

            if (cur.left != null) {
                queue.add(cur.left);
            } else {
                queue.add(null);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            } else {
                queue.add(null);
            }
        }
        return Arrays.toString(list.toArray());
    }

    // 用StringBuilder存储，用时效率比List高
    public String serialize2(TreeNode root) {

        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {

        if (data.equals("[]")) {
            return null;
        }
        // 用List的话这里的分割逗号后面需要加个空格
        String[] values = data.substring(1, data.length() - 1).split(", ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!values[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.left);
            }
            i++;
            if (!values[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        //            1
        //          /   \
        //         2     3
        //             / \
        //            4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String result = new Solution().serialize(root);
        System.out.println("序列化结果：" + result);
    }

}
