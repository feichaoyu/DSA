package 数据结构.数组;

/**
 * @Author feichaoyu
 * @Date 2019/12/25
 */
public class ArrayTest {

    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        for(int i = 0 ; i < 10 ; i ++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.remove(0);
        System.out.println(arr);

        arr.remove(arr.getSize() - 1);
        System.out.println(arr);

//        arr.add(1, 100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);
    }
}
