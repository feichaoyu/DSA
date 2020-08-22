ArrayStack<E>  复杂度分析

void push(E)       O(1) 均摊
E pop()            O(1) 均摊
E peek()           O(1)
int getSize()      O(1)
boolean isEmpty()  O(1)

用数组和链表实现栈的复杂度在一般情况下都是 O(1)    但是当数量很大时，链表由于会有new Node的过程，所以性能不比数组好
