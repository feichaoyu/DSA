ArrayQueue<E>   复杂度分析

void enqueue(E)      O(1) 均摊
E dequeue()          O(n)
E front()            O(1)
int getSize()        O(1)
boolean isEmpty()    O(1)

-------------------
循环队列
front==tail 队列为空     (tail+1) % capacity == front  队列为满
入队 tail++
出队 front++


--------------------
LoopQueue<E>      复杂度分析

void enqueue(E)     O(1) 均摊
E dequeue()         0(1) 均摊
E getFront()        0(1)
int getSize()       0(1)
boolean isEmpty()   0(1)

---------------------
普通队列：先进先出，后进后出
优先队列：出队顺序和入队顺序无关，和优先级有关

                入队      出队（拿出最大元素）
普通线性结构      O(1)        O(n)
顺序线性结构      O(n)        O(1)
堆              O(logn)     O(logn)

利用堆实现优先队列
Java自带的PriorityQueue是最小堆实现的
