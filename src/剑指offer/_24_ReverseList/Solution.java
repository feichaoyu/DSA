package 剑指offer._24_ReverseList;

/**
 * @author feichaoyu
 */
public class Solution {

    public ListNode reverseList(ListNode head) {

        // 递归
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode newHead = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;

        // 迭代
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            // 保存下一个节点，因为下面cur的指向会丢失
            ListNode temp = cur.next;
            // 局部反转
            cur.next = prev;
            // 同时向右移动一步，进入下一次
            prev = cur;
            cur = temp;
        }
        return prev;
    }

}
