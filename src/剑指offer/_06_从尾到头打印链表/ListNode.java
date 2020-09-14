package 剑指offer._06_从尾到头打印链表;

/**
 * @author feichaoyu
 */
public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode(T val) {
        this.val = val;
    }

//    @Override
//    public String toString() {
//        StringBuilder ret = new StringBuilder();
//        ret.append("[");
//        for (ListNode cur = this; ; cur = cur.next) {
//            if (cur == null) {
//                ret.deleteCharAt(ret.lastIndexOf(" "));
//                ret.deleteCharAt(ret.lastIndexOf(","));
//                break;
//            }
//            ret.append(cur.val);
//            ret.append(", ");
//        }
//        ret.append("]");
//        return ret.toString();
//    }
}
