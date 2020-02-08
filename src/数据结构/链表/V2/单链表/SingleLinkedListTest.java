package 数据结构.链表.V2.单链表;

/**
 * @Author feichaoyu
 * @Date 2020/1/6
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList<Object> list = new SingleLinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        System.out.println(list);

        list.reverse();
        System.out.println("reverse:" + list);
        list.reverseNR();

        System.out.println("reverseNR:" + list);

    }
}
