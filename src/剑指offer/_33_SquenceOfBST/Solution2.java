package 剑指offer._33_SquenceOfBST;

/**
 * 简洁版分治
 *
 * @author feichaoyu
 */
public class Solution2 {

    public boolean verifyPostorder(int[] postorder) {

        return isAfterOrder(postorder, 0, postorder.length - 1);
    }

    boolean isAfterOrder(int[] postorder, int i, int j) {

        // 当 i ≥ j ，说明此子树节点数量 ≤1 ，直接返回 true
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && isAfterOrder(postorder, i, m - 1) && isAfterOrder(postorder, m, j - 1);
    }
}
