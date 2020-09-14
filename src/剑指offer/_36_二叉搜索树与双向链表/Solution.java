package 剑指offer._36_二叉搜索树与双向链表;

/**
 * @author feichaoyu
 */
public class Solution {

    private Node pre, head;

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }
        // 转化为双向链表
        inOrder(root);
        // 构建循环链表
        // 1.头节点的前驱指向尾节点
        head.left = pre;
        // 2.尾节点的后继指向头节点
        pre.right = head;

        return head;
    }

    private void inOrder(Node cur) {

        if (cur == null) {
            return;
        }

        inOrder(cur.left);
        // 当pre为空时，代表正在访问链表头节点，记为head
        if (pre == null) {
            head = cur;
        }
        // 当pre不为空时，修改双向节点引用
        else {
            pre.right = cur;
            cur.left = pre;
        }
        // 更新pre
        pre = cur;
        inOrder(cur.right);
    }
}
