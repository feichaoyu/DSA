并查集：由孩子指向父亲
![lgXrOf.png](https://s2.ax1x.com/2020/01/08/lgXrOf.png)

UnionFind2 由于只往一个节点上合并，因此可能会退化成链表

UnionFind3 （size优化）根据两边节点的数目，让数目少的合并到数目多的节点上

UnionFind4 （rank优化）由于UnionFind3存在一个问题：当某一个节点存在大量深度为1的子节点，
那么这时候节点数目明显是更多的，如果让另一个节点少的但是深度大的合并过来，那么深度反而会增大。
因此这时候基于size的优化就不太可靠了，采取基于深度的优化更优。

也就是比较的是每个节点的子节点的深度，而不是拥有的子节点数目

size优化（深度为4）
![l2iYvQ.png](https://s2.ax1x.com/2020/01/08/l2iYvQ.png)

rank优化（深度为3）
![l2iG8S.png](https://s2.ax1x.com/2020/01/08/l2iG8S.png)


UnionFind5（路径压缩）在find的时候进行路径压缩，降低深度

![l2ZvIs.png](https://s2.ax1x.com/2020/01/08/l2ZvIs.png)

UnionFind6（路径压缩优化）利用递归让节点全部指向根节点

![l2KZnK.png](https://s2.ax1x.com/2020/01/08/l2KZnK.png)
