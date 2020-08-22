package 分类刷题.链表.反转链表;

public class Solution1 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        return dfs(head);
    }

    private ListNode dfs(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode newHead = null;
        newHead = dfs(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
