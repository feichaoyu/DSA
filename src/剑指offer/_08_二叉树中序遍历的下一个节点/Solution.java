package 剑指offer._08_二叉树中序遍历的下一个节点;

/**
 * @author feichaoyu
 */
public class Solution {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode father;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.father = null;
        }
    }

    /**
     * 中序遍历节点有如下特征：
     * 1.如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点
     * 2.如果一个节点没有右子树，并且是它父节点的左子节点，那么它的下一个节点就是父节点
     * 3.如果一个节点没有右子树，并且是它父节点的右子节点，那么沿着父节点向上遍历，直到找到一个是它父节点的左子节点的节点，
     * 如果存在这样的节点，那么它的父节点就是要找的下一个节点
     */
    public static TreeNode getNext(TreeNode node) {

        if (node == null) {
            return null;
        }

        // 1.如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点
        if (node.right != null) {
            TreeNode cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 2.如果一个节点没有右子树，并且是它父节点的左子节点，那么它的下一个节点就是父节点
        else if (node.father != null) {
            if (node.father.left.val == node.val) {
                return node.father;
            }
            // 3.如果一个节点没有右子树，并且是它父节点的右子节点，那么沿着父节点向上遍历，
            // 直到找到一个是它父节点的左子节点的节点，如果存在这样的节点，那么它的父节点就是要找的下一个节点
            else if (node.father.right.val == node.val) {
                TreeNode cur = node.father;
                while (cur.father != null) {
                    if (cur.father.right.val == cur.val) {
                        cur = cur.father;
                    } else if (cur.father.left.val == cur.val) {
                        return cur.father;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public static void main(String[] args){
        //            1
        //          // \\
        //         2     3
        //       // \\
        //      4     5
        //    inorder->42513
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.father = root;
        root.right = new TreeNode(3);
        root.right.father = root;
        root.left.left = new TreeNode(4);
        root.left.left.father = root.left;
        root.left.right = new TreeNode(5);
        root.left.right.father = root.left;

        System.out.println(getNext(root.left.left).val);
        System.out.println(getNext(root.left).val);
        System.out.println(getNext(root.left.right).val);
        System.out.println(getNext(root).val);
        System.out.println(getNext(root.right));
    }
}

