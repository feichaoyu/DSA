package 数据结构.树.并查集;

/**
 * @Author feichaoyu
 * @Date 2020/1/8
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
