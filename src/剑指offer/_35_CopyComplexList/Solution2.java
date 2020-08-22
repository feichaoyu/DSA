package 剑指offer._35_CopyComplexList;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }
        cloneNodes(head);
        connectRandomNodes(head);
        return reconnectNodes(head);
    }

    /**
     * 拷贝每个节点，并将拷贝的节点插入到原来节点的后面
     *
     * @param head
     */
    private void cloneNodes(Node head) {
        Node cur = head;
        Node temp;
        while (cur != null) {
            // 复制一个当前节点
            temp = new Node(cur.val);
            // 把复制的节点插入到当前节点后面
            temp.next = cur.next;
            cur.next = temp;
            // 指向原来节点的下一个，需要跳过复制的节点
            cur = cur.next.next;
        }
    }

    /**
     * 初始化拷贝节点的random指针
     *
     * @param head
     */
    private void connectRandomNodes(Node head) {
        Node cur = head;
        Node copyCur = head.next;
        while (true) {
            if (cur.random != null) {
                copyCur.random = cur.random.next;
            }
            cur = cur.next.next;
            if (cur == null) {
                break;
            }
            copyCur = copyCur.next.next;
        }
    }

    private Node reconnectNodes(Node head) {
        Node copyHead = head.next;
        Node cur = head;
        Node copyCur = copyHead;
        while (true) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (cur == null) {
                copyCur.next = null;
                break;
            }
            copyCur.next = copyCur.next.next;
            copyCur = copyCur.next;
        }
        return copyHead;
    }
}
