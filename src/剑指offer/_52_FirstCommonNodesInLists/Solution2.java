package 剑指offer._52_FirstCommonNodesInLists;

/**
 * 使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，
 * 当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
 * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
 *
 * @author feichaoyu
 */
public class Solution2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 != null ? node1.next : headB;
            node2 = node2 != null ? node2.next : headA;
        }
        return node1;
    }
}
