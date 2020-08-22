package 剑指offer._22_01_KthNodeFromEnd;

/**
 * 双指针
 *
 * @author feichaoyu
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null || k == 0) {
            return null;
        }

        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // fast 指针先向前走 k-1 步
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            }
            // 在这期间如果fast的下一个节点为null，说明根本没有倒数第 k 个节点
            else {
                return null;
            }
        }

        // 从第 k 步开始， slow指针也开始从头开始遍历，
        // 由于两个指针的距离保持在 k-1，当 fast 指针到达链表的尾结点时，slow 指针正好指向倒数第 k 个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
