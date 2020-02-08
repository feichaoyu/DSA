package 数据结构.树.线段树;

/**
 * @Author feichaoyu
 * @Date 2020/1/4
 */
public class SegmentTreeTest {
    public static void main(String[] args) {

        Integer[] nums = {-2, 0, 3, -5, 2, -1, -1, -2};
//        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
//                new Merger<Integer>() {
//                    @Override
//                    public Integer merge(Integer a, Integer b) {
//                        return a + b;
//                    }
//                });

        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b);
        System.out.println(segTree);

        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }
}
