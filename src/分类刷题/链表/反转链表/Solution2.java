package 分类刷题.链表.反转链表;

public class Solution2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }

        if (m < 2) {
            // 找到右边位置并记录
            for (int i = 0; i < n - m + 2; i++) {
                head = head.next;
            }
            ListNode right = head;

            head = dfs(head, right);
            ListNode newHead = head;

            for (int i = 0; i < n - m + 1; i++) {
                head = head.next;
            }
            head.next = right;
            return newHead;
        } else {
            ListNode newHead = head;
            // 找到左边位置并记录
            for (int i = 0; i < m - 2; i++) {
                head = head.next;
            }
            ListNode left = head;
            ListNode leftTemp = head;

            // 找到右边位置并记录
            for (int i = 0; i < n - m + 2; i++) {
                head = head.next;
            }
            ListNode right = head;

            left.next = dfs(leftTemp.next, right);

            for (int i = 0; i < n - m + 1; i++) {
                left = left.next;
            }
            left.next = right;
            return newHead;
        }
    }

    private ListNode dfs(ListNode head, ListNode end) {
        if (head.next == end) {
            return head;
        }

        ListNode newHead = null;
        newHead = dfs(head.next, end);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}


