package 剑指offer._23_EntryNodeInListLoop;

/**
 * @author feichaoyu
 */
public class Solution {

    /**
     * 分两步：
     * 1.找到相遇节点
     * 2.求出环中节点数
     * 3.找到入口节点
     *
     * @param head
     * @return
     */
    public int findCycleEntry(ListNode head) {

        // 1.找到相遇节点
        ListNode meetingNode = getMeetingNode(head);
        if (meetingNode == null) {
            return -1;
        }
        // 2.求出环中节点数
        int nodesInLoop = 1;
        ListNode node = meetingNode;
        while (node.next != meetingNode) {
            node = node.next;
            nodesInLoop++;
        }
        // 3.找到入口节点
        // 先让 fast 指针移动环中节点数的步数
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < nodesInLoop; i++) {
            fast = fast.next;
        }
        // 再让两个指针一起移动直到相遇，相遇节点就是环的入口节点
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    /**
     * 找出相遇节点
     *
     * @param head
     * @return
     */
    private ListNode getMeetingNode(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.println(new Solution().findCycleEntry(head));
    }
}
