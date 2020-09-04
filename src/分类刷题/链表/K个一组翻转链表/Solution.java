package 分类刷题.链表.K个一组翻转链表;

/**
 * 参考https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // end指针向后走k步，我们就开始翻转链表
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 发现end为null认为无法翻转，直接结束
            if (end == null) {
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            // 断开end后面的节点，让start到end结尾作为一个新的链表
            end.next = null;
            // 反转链表，链表是从start到end结尾
            pre.next = reverse(start);
            // 反转完以后，start就变成最后一个节点，让start连接之前断开的链表
            start.next = next;
            // 重置pre和end指针
            pre = end = start;
        }
        return dummy.next;
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
