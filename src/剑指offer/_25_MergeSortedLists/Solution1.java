package 剑指offer._25_MergeSortedLists;

/**
 * 迭代法
 *
 * @author feichaoyu
 */
public class Solution1 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 设置虚拟节点（哑节点）
        ListNode dummyHead = new ListNode(-1);

        // 设置一个prev节点指向dummyHead
        ListNode prev = dummyHead;

        // 此时考虑的是l1的长度和l2相同，并且l1和l2都不指向null，那么每个节点依次判断
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 否则直接把超出长度节点的拼接在while循环后得到的prev后面，因为这是有序列表，后面的数字一定比前面大
        prev.next = l1 == null ? l2 : l1;

        // 返回虚拟节点的后一个节点，就是处理完的链表
        return dummyHead.next;
    }
}
