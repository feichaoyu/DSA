package 剑指offer._54_KthNodeInBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author feichaoyu
 */
public class Solution {

    private int res;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        if (--k == 0) {
            res = root.val;
        }
        inOrder(root.left);
    }
}
