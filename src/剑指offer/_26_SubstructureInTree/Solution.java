package 剑指offer._26_SubstructureInTree;

/**
 * @author feichaoyu
 */
public class Solution {

    /**
     * 思路：
     * 1.在树A中找到和树B根节点的值一样的节点R
     * 2.判断树A中以节点R为根的子树是否包含和树B一样的结构
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        boolean result = false;
        if (A != null && B != null) {
//            if (A.val == B.val) {
//                // 判断以节点A为根节点的子树是否包含树B
//                result = doesTreeAHavaTreeB(A, B);
//            }
//            if (!result) {
//                // 如果上面不包含，则判断A的左子树是否含有B的根节点
//                result = isSubStructure(A.left, B);
//            }
//            if (!result) {
//                // 如果A的左子树也不包含，则判断A的右子树是否含有B的根节点
//                result = isSubStructure(A.right, B);
//            }

            // 上面可以直接简化为如下一行代码
            result = doesTreeAHavaTreeB(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        return result;
    }

    private boolean doesTreeAHavaTreeB(TreeNode A, TreeNode B) {

        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return doesTreeAHavaTreeB(A.left, B.left) && doesTreeAHavaTreeB(A.right, B.right);
    }
}
