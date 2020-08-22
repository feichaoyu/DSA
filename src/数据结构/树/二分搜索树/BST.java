package 数据结构.树.二分搜索树;

import 剑指offer._07_ConstructBinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 这个二分搜索树不包含重复元素
 *
 * @Author feichaoyu
 * @Date 2019/12/30
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     *
     * @param node 根
     * @param e    需要插入的元素
     * @return Node 插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 是否包含元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 从以node为根的二分搜索树中查找元素e，递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历，非递归实现
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            Node cur = stack.pop();
//            System.out.println(cur.e);
//
//            // 先压右，再压左
//            // 这样取出时，先取左，再取右
//            if (cur.right != null) {
//                stack.push(cur.right);
//            }
//            if (cur.left != null) {
//                stack.push(cur.left);
//            }
//        }
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                System.out.print(cur.e);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    /**
     * 前序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历，非递归实现
     */
    public void inOrderNR() {

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 当前节点无子树
            else {
                cur = stack.pop();
                System.out.print(cur.e);
                cur = cur.right;
            }
        }
    }

    /**
     * 中序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历，非递归实现
     */
    public void postOrderNR() {

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        // 标记最近出栈的节点，用于判断是否是prevVisted节点的右孩子，如果是的话，就可以访问prevVisted节点
        Node prevVisted = null;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.peek().right;
                if (cur != null && cur != prevVisted) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    prevVisted = stack.pop();
                    System.out.print(prevVisted.e);
                    cur = null;
                }
            }
        }
    }

    /**
     * 后序遍历以node为根的二分搜索树，递归算法
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点，返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            // 保存右节点(不管是否为空)
            Node rightNode = node.right;
            // 将待删节点的右节点指向空
            node.right = null;
            // 长度减少
            size--;
            // 返回保存的右节点
            return rightNode;
        }

        // 将传入根节点的左节点指向之前保存的右节点（原来的左节点被删了）
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点
     *
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点，返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {

        if (node.right == null) {
            // 保存左节点(不管是否为空)
            Node leftNode = node.left;
            // 将待删节点的左节点指向空
            node.left = null;
            // 长度减少
            size--;
            // 返回保存的左节点
            return leftNode;
        }

        // 将传入根节点的右节点指向之前保存的左节点（原来的右节点被删了）
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        // e == node.e 就是需要删除的节点
        else {
            if (node.left == null) {
                // 待删除节点左子树为空的情况
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                // 待删除节点右子树为空的情况
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点，用这个节点顶替待删除节点的位置

            // 先找到后继节点（右子树的最小节点）
            Node successor = minimum(node.right);
            // 后继节点的右节点 指向 待删节点右节点中移除了最小节点之后的节点
            successor.right = removeMin(node.right);
            //size++;
            // 后继节点的左节点 指向 待删节点的左节点
            successor.left = node.left;
            // 待删节点脱离
            node.left = node.right = null;
            //size--;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
