package 剑指offer._52_FirstCommonNodesInLists;

/**
 * 先遍历一遍得到两个链表的长度，然后让长度长的先走，走的步数是两者差值。然后再一起走，直到啷个节点相等（注意不是比较值）
 *
 * @author feichaoyu
 */
public class Solution1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        // 先遍历一遍链表统计长度
        int lenA = 0;
        int lenB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            tempA = tempA.next;
            lenA++;
        }

        while (tempB != null) {
            tempB = tempB.next;
            lenB++;
        }

        int diff = 0;
        // 链表A的长度大于B
        if (lenA - lenB > 0) {
            // 让A先走超过的长度
            diff = lenA - lenB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }

            // 根据B来
            for (int i = 0; i < lenB; i++) {
                if (headA == headB) {
                    return headA;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
            return null;
        } else {
            // 让B先走超过的长度
            diff = lenB - lenA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }

            // 根据A来
            for (int i = 0; i < lenA; i++) {
                if (headA == headB) {
                    return headA;
                } else {
                    headA = headA.next;
                    headB = headB.next;
                }
            }
            return null;
        }
    }
}
