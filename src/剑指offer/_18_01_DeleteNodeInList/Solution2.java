package 剑指offer._18_01_DeleteNodeInList;

/**
 * O(1)
 * O(1)时间内删除要求我们打破常规的思维模式。
 * 当我们想删除一个节点时，并不一定要删除这个节点本身。
 * 可以先把下一个节点的内容复制出来覆盖被删除节点的内容，然后把下一个节点删除。
 *
 * @author feichaoyu
 */
public class Solution2 {

    // 这里的第二参数是 ListNode 类型，而不是int
    public static ListNode deleteNode(ListNode head, ListNode val) {

        if (head == null || val == null) {
            return null;
        }
        // 待删除节点不是尾节点
        if (val.next != null) {
            ListNode next = val.next;
            val.val = next.val;
            val.next = next.next;
        }
        // 待删除节点只有一个节点，此节点为头节点
        else if (head == val) {
            head = null;
        }
        // 待删除节点为尾节点
        else {
            ListNode cur = head;
            while (cur.next != val) {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        System.out.println(head);
        head = deleteNode(head, node3);
        System.out.println(head);
        head = deleteNode(head, head);
        System.out.println(head);
    }
}
