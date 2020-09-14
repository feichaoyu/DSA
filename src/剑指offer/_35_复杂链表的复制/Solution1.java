package 剑指offer._35_复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        // 深拷贝链表，不包括random指针
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);
        Node cur = head.next;
        Node copyCur;
        Node copyPrev = copyHead;
        while (cur != null) {
            copyCur = new Node(cur.val);
            map.put(cur, copyCur);
            copyPrev.next = copyCur;
            copyPrev = copyPrev.next;
            cur = cur.next;
        }
        // 拷贝random指针
        cur = head;
        copyCur = copyHead;
        while (cur != null) {
            // 当前节点有random指针
            if (cur.random != null) {
                // map.get(cur.random) 获取的就是对应拷贝的random节点
                copyCur.random = map.get(cur.random);
            }
            cur = cur.next;
            copyCur = copyCur.next;

            // 如果不用hashmap，则代码如下
//            Node temp = head;
//            Node newTemp = copyHead;
//            while (temp != cur.random) {
//                temp = temp.next;
//                newTemp = newTemp.next;
//            }
//            copyCur.random = newTemp;
        }
        return copyHead;
    }
}
