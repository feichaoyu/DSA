package 数据结构.树.并查集;

/**
 * @Author feichaoyu
 * @Date 2020/1/8
 */
public class UnionFind5 implements UF {

    /**
     * parent[i]表示第一个元素所指向的父节点
     */
    private int[] parent;

    /**
     * rank[i]表示以i为根的集合所表示的树的深度
     * 这里已经不代表深度了，已经经过了路径压缩，但是不影响rank的使用，因为它只是作为一个比较条件
     * 在后续的代码中, 我们并不会维护rank的语意, 也就是rank的值在路径压缩的过程中, 有可能不在是树的层数值
     * 这也是我们的rank不叫height或者depth的原因, 他只是作为比较的一个标准
     */
    private int[] rank;

    public UnionFind5(int size) {

        parent = new int[size];
        rank = new int[size];

        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自成一个集合
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找元素p所对应的集合编号, O(h)复杂度, h为树的高度
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        // 不断去查询自己的父节点, 直到到达根节点
        // 根节点的特点: 初始化parent时，parent[p] == p
        while (p != parent[p]) {
            // 压缩分裂（每个节点都要找祖父节点）
//            int tmp = parent[p];
//            parent[p] = parent[parent[p]];
//            p = tmp;

            // 路径分割（奇数节点找祖父节点）
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    /**
     * 查看元素p和元素q是否所属一个集合，O(h)复杂度, h为树的高度
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p和元素q所属的集合, O(h)复杂度, h为树的高度
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的rank深度不同判断合并方向
        // 将rank小的集合合并到rank大的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else { // rank[qRoot] = rank[pRoot]
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }
}

