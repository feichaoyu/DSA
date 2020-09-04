package 分类刷题.链表.合并K个升序链表;

public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode node = null;
        for (int i = 0; i < lists.length; i++) {
            node = mergeTwoListsRecursion(node, lists[i]);
        }
        return node;
    }

    /**
     * 递归写法
     */
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        }
    }
}
