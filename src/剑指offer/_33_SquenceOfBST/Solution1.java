package 剑指offer._33_SquenceOfBST;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归分治，自己写的，还可以优化为Solution2
 *
 * @author feichaoyu
 */
public class Solution1 {

    /**
     * 分三步：
     * 1.先找到给定序列的根节点(最后一个数字)
     * 2.找到左子树节点和右子树节点
     * 3.用同样的方式递归左子树和右子树
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {

        if (postorder.length == 0) {
            return true;
        }

        return isAfterOrder(postorder);
    }

    private boolean isAfterOrder(int[] postorder) {

        if (postorder.length == 0) {
            return true;
        }

        int root = postorder[postorder.length - 1];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < postorder.length - 1; i++) {
            if (postorder[i] > root) {
                for (int j = i; j < postorder.length - 1; j++) {
                    if (postorder[j] > root) {
                        right.add(postorder[j]);
                    } else {
                        return false;
                    }
                }
                break;
            }
            left.add(postorder[i]);
        }
        int[] leftOrder = new int[left.size()];
        int[] rightOrder = new int[right.size()];
        for (int i = 0; i < left.size(); i++) {
            leftOrder[i] = left.get(i);
        }
        for (int i = 0; i < right.size(); i++) {
            rightOrder[i] = right.get(i);
        }

        return isAfterOrder(leftOrder) && isAfterOrder(rightOrder);
    }
}
