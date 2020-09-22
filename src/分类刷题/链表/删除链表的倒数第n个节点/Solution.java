package 分类刷题.链表.删除链表的倒数第n个节点;

public class Solution {

    // 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        // fast 指针先向前走 n+1 步
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 从第 n+1 步开始， slow指针也开始从头开始遍历，
        // 由于两个指针的距离保持在 n，当 fast 指针到达链表的尾结点的下一个节点时，slow 指针正好指向倒数第 n-1 个节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 然后让slow下一个指向slow的下下个节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
