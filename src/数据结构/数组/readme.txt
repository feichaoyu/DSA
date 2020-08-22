时间复杂度分析：
增：O(n)
删：O(n)
查：已知索引O(1)，未知索引O(n)
改：已知索引O(1)，未知索引O(n)

-----------
均摊时间复杂度
resize  O(n)

假设capacity=8，那么9次addLast操作，触发resize，总共进行了17次（9次addLast+扩容会发生8次赋值操作）基本操作，平均每次addLast操作，进行2次基本操作
假设capacity=n，n+1次addLast，触发resize，总共进行2n+1次基本操作平均，每次addLast操作，进行2次基本操作

平均每次addLast操作，进行2次基本操作。这样均摊计算，addLast时间复杂度是O(1)

一个相对比较耗时的操作，如果我们能保证它不是每次都触发的话，那么这个相对比较耗时操作的时间是可以分摊到其他操作中来的

-----------
复杂度震荡
比如现在刚好是到原始数组末尾了，当addLast之后又removeLast，然后又addLast，removeLast，那么其实一直都在执行扩容和缩容操作，即每次都触发resize
出现问题的原因：removeLast 时 resize 过于着急（Eager）
解决方案：Lazy  当size==capacity/4时，才将capacity减半
