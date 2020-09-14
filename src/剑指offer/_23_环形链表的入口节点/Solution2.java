package 剑指offer._23_环形链表的入口节点;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public int findCycleEntry(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                for (ListNode node : set) {
                    if (node == head) {
                        return node.val;
                    }
                }
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.println(new Solution2().findCycleEntry(head));
    }
}
