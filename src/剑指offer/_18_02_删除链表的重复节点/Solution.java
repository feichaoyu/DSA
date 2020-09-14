package 剑指offer._18_02_删除链表的重复节点;

/**
 * @author feichaoyu
 */
public class Solution {

    public static ListNode deleteDuplication(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        ListNode cur = prev.next;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            } else {
                // 题目为删除链表中重复的结点，重复的结点不保留
                // 如果保留一个重复的节点下面应改为 prev.next = cur;
                prev = prev.next;
            }
            cur = cur.next;

        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        System.out.println(head);
        head = deleteDuplication(head);
        System.out.println(head);
    }
}
