package 数据结构.集合Set;

import 数据结构.树.AVL.AVLTree;

/**
 * @Author feichaoyu
 * @Date 2020/1/9
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E, Object> avl;

    public AVLSet() {
        avl = new AVLTree<>();
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }
}

