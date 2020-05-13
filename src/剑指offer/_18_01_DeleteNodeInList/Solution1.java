package 剑指offer._18_01_DeleteNodeInList;

/**
 * O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public static ListNode deleteNode(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        // 找到
        if (cur.next != null) {
            cur.next = cur.next.next;
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
        head = deleteNode(head,3);
        System.out.println(head);
        head = deleteNode(head,1);
        System.out.println(head);
    }
}
