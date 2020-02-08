LinkedList  复杂度分析
添加操作  O(n)
addLast(e)      O(n)
addFirst(e)     O(1)
add(index, e)   O(n/2) = O(n)

删除操作  O(n)
removeLast(e)      O(n)
removeFirst(e)     O(1)
remove(index, e)   O(n/2) = O(n)

修改操作  O(n)
set(index, e)    O(n)

查找操作  O(n)
get(index)       O(n)
contains(e)      O(n)

-------------
链表实现栈
对于链表，如果只对链表头进行增删操作：O(1)，只查询链表头：O(1)
因此可以用链表实现栈，见 栈 那一节LinkedListStack

-------------
链表实现队列
对于链表，如果只对链表头进行增删操作：O(1)，只查询链表头：O(1)
对链表尾的增删查操作都是 O(n)
然而对于队列，必然有一方是插入元素，一方是删除元素，势必在两端同时操作，此时必然有一方的复杂度是 O(n)
因此需要新增一个尾指针tail
此时
head端 添加删除元素都是 O(1)
tail端 添加元素 O(1)，删除元素 O(n)
因此
head作为队首，tail作为队尾   即从head端删除元素，从tail端添加元素
实现见 队列 那一节LinkedListQueue

