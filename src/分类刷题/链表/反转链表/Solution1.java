package 分类刷题.链表.反转链表;

/**
 * 反转整个链表
 */
public class Solution1 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
