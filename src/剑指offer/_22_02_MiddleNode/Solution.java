package 剑指offer._22_02_MiddleNode;

/**
 * 一个指针一次走一步，另一个指针一次走两步，当走的快的指针走到链表的末尾时，走的慢的指针正好在链表中间。
 *
 * @author feichaoyu
 */
public class Solution {

    public ListNode getMiddleNode(ListNode head) {

        if (head == null) {
            return null;
        }

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(new Solution().getMiddleNode(head));
    }
}
