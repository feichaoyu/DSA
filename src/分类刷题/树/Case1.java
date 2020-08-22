package 分类刷题.树;

import java.util.*;

/**
 * 以下涉及的二叉树均是指二分搜索树
 * <p>
 * 1.如何把一个有序整数数组放到二叉树中
 * <p>
 * 2.逐层打印二叉树结点数据(层序遍历)
 * <p>
 * 3.求最大子树和，结点可以是正整数或负整数(后序遍历)
 * <p>
 * 4.判断两棵二叉树是否相等
 * <p>
 * 5.将二叉树转换成一个排序的双向链表，且不能创建新的结点，只能调整结点的指向
 * <p>
 * 6.判断一个数组是否是二叉树的后序遍历的序列
 * <p>
 * 7.求两个结点的最近公共父结点
 * <p>
 * 8.复制二叉树
 * <p>
 * 9.找出所有路径满足：这条路径上的所有结点数据和等于给定的整数
 * <p>
 * 10.对二叉树镜像反转
 * <p>
 * 11.找出二叉树中第一个（相距最近）大于中间值的结点
 * <p>
 * 12.找出二叉树中路径最大的和，路径可以以任意结点作为起点和终点
 */
public class Case1 {

    /**
     * 可以接受的最小值（可以是负数）
     */
    private static int maxSum = Integer.MIN_VALUE;

    /**
     * 可以接受的最小值（可以是负数）
     */
    private static int maxSum2 = Integer.MIN_VALUE;

    /**
     * 双向链表头结点
     */
    private static TreeNode pHead = null;

    /**
     * 双向链表尾结点
     */
    private static TreeNode pEnd = null;

    /**
     * 1.把有序数组转换成二叉树
     *
     * @param arr   传入的有序数组
     * @param start 数组开始索引
     * @param end   数组末尾索引
     * @return 树的根节点
     */
    public static TreeNode arrayToTree(int[] arr, int start, int end) {
        TreeNode root = null;
        if (end >= start) {
            root = new TreeNode();
            int mid = start + (end - start + 1) / 2;
            // 数组中间元素作为根节点
            root.data = arr[mid];
            // 递归构造左半边子树
            root.left = arrayToTree(arr, start, mid - 1);
            // 递归构造右半边子树
            root.right = arrayToTree(arr, mid + 1, end);
        } else {
            root = null;
        }

        return root;
    }

    /**
     * 中序遍历打印二叉树节点
     *
     * @param root 传入的根节点
     */
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * 2.层序遍历
     *
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            System.out.print(cur.data + " ");

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    /**
     * 3.求最大子树和
     *
     * @param root    根节点
     * @param maxRoot 最大子树的根节点
     * @return 以root为根节点所有子树的和
     */
    public static int findMaxSubTree(TreeNode root, TreeNode maxRoot) {
        if (root == null) {
            return 0;
        }

        int leftSum = findMaxSubTree(root.left, maxRoot);
        int rightSum = findMaxSubTree(root.right, maxRoot);
        int sum = leftSum + rightSum + root.data;

        // 更新最大值
        if (sum > maxSum) {
            maxSum = sum;
            maxRoot.data = root.data;
        }

        return sum;
    }

    /**
     * 4.判断两棵二叉树是否相等
     *
     * @param root1 根结点
     * @param root2 根结点
     * @return 两棵树相等返回true，否则false
     */
    public static boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data == root2.data) {
            return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
        } else {
            return false;
        }
    }

    /**
     * 5.将二叉树转换成排好序的双向链表
     *
     * @param root 根结点
     */
    public static void treeToLinkedList(TreeNode root) {
        // 由于中序遍历是有序的，因此可以在中序遍历中通过修改结点的指向来转换成一个排序的双向链表
        if (root == null) {
            return;
        }

        // 转换左子树
        treeToLinkedList(root.left);

        // 当前节点的左子树指向双向链表中最后一个节点
        root.left = pEnd;
        // 双向链表为空，当前遍历的结点是双向链表的头结点
        if (pEnd == null) {
            pHead = root;
        }
        // 双向链表中最后一个结点的右子树指向当前结点root，此时root被加入到双向链表中
        else {
            pEnd.right = root;
        }
        // 更新pEnd
        pEnd = root;

        // 转换右子树
        treeToLinkedList(root.right);
    }

    /**
     * 6.判断一个数组是否是二叉树的后序遍历的序列
     *
     * @param arr   传入的数组
     * @param start 开始索引
     * @param end   结束索引
     * @return 如果传入的数组符合后序遍历的特点，那么就说明该数组是后序遍历的序列，返回true
     */
    public static boolean isAfterOrder(int[] arr, int start, int end) {
        if (arr == null) {
            return false;
        }
        // 数组最后一个结点必定是根节点
        int root = arr[end];
        int i, j;
        // 找到第一个大于root的值，那么前面所有结点都位于root的左子树上
        for (i = start; i < end; i++) {
            if (arr[i] > root) {
                break;
            }
        }

        // 如果序列是后序遍历的序列，那么从i开始的所有值都应该大于根节点root的值
        for (j = i; j < end; j++) {
            if (arr[j] < root) {
                return false;
            }
        }

        boolean leftIsPostOrder = true;
        boolean rightIsPostOrder = true;
        // 判断小于root值的序列是否是二叉树的后序遍历
        if (i > start) {
            leftIsPostOrder = isAfterOrder(arr, start, i - 1);
        }
        // 下面这个有点多余。走到这里的话，j = end
        if (j < end) {
            rightIsPostOrder = isAfterOrder(arr, i, end);
        }
        return leftIsPostOrder && rightIsPostOrder;
    }

    /**
     * 7.求两个结点的最近公共父结点 （使用栈）
     *
     * @param root  根结点
     * @param node1 结点1
     * @param node2 结点2
     * @return node1和node2中的最近公共父结点
     */
    public static TreeNode findParentNode(TreeNode root, TreeNode node1, TreeNode node2) {
        // 保存从root到node1的路径
        Stack<TreeNode> stack1 = new Stack<>();
        // 保存从root到node2的路径
        Stack<TreeNode> stack2 = new Stack<>();

        // 获取从root到node1的路径
        getPathFromRoot(root, node1, stack1);

        // 获取从root到node2的路径
        getPathFromRoot(root, node2, stack2);

        TreeNode commonParent = null;
        // 获取最靠近node1和node2的父结点
        while (stack1.peek() == stack2.peek()) {
            commonParent = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return commonParent;
    }

    /**
     * 获取二叉树从根结点root到node结点的路径
     *
     * @param root  根结点
     * @param node  二叉树中的结点
     * @param stack 用于存储路径的栈
     * @return 如果node在root的子树上，或node==root时，返回true，否则返回false
     */
    private static boolean getPathFromRoot(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            stack.push(root);
            return true;
        }

        // 如果node结点在root结点的左子树或右子树上，那么root就是node的祖先结点，就把它加入栈中
        if (getPathFromRoot(root.left, node, stack) || getPathFromRoot(root.right, node, stack)) {
            stack.push(root);
            return true;
        }

        return false;

    }

    /**
     * 7.2求两个结点的最近公共父结点（改装后序遍历，空间复杂度为O(1)）
     *
     * @param root  根结点
     * @param node1 结点1
     * @param node2 结点2
     * @return node1和node2中的最近公共父结点
     */
    public static TreeNode findParentNode2(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        TreeNode left = findParentNode2(root.left, node1, node2);
        TreeNode right = findParentNode2(root.right, node1, node2);

        // root左子树中没有结点node1和node2，那么一定在root右子树上
        if (left == null) {
            return right;
        }
        // root右子树中没有结点node1和node2，那么一定在root左子树上
        else if (right == null) {
            return left;
        }
        // node1和node2分别位于root左子树和右子树上，那么root就是它们的公共父结点
        else {
            return root;
        }
    }

    /**
     * 8.复制二叉树
     *
     * @param root 根结点
     * @return 复制的新的二叉树
     */
    public static TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newTree = new TreeNode();
        // 复制根结点
        newTree.data = root.data;
        // 复制左子树
        newTree.left = copyTree(root.left);
        // 复制右子树
        newTree.right = copyTree(root.right);

        return newTree;
    }

    /**
     * 9.找出所有路径满足：这条路径上的所有结点数据和等于给定的整数（打印路径出来）
     *
     * @param root 根结点
     * @param num  给定的整数
     * @param sum  当前路径上所有结点的和
     * @param list 用来存储从根结点到当前便利的结点的路径
     */
    public static void findRoad(TreeNode root, int num, int sum, List<Integer> list) {
        // 记录当前遍历的root结点
        sum += root.data;
        list.add(root.data);
        // 当前结点是叶子结点且遍历的路径上所有结点的和等于num
        if (root.left == null && root.right == null && sum == num) {
            // 打印
            list.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }

        // 遍历root的左子树
        if (root.left != null) {
            findRoad(root.left, num, sum, list);
        }

        // 遍历root的右子树
        if (root.right != null) {
            findRoad(root.right, num, sum, list);
        }

        // 向上清除遍历的路径
        sum -= list.get(list.size() - 1);
        list.remove(list.size() - 1);
    }

    /**
     * 10.对二叉树镜像反转（交换所有结点的左右孩子）
     *
     * @param root 根结点
     */
    public static void reverseTree(TreeNode root) {
        if (root == null) {
            return;
        }

        reverseTree(root.left);
        reverseTree(root.right);

        // 交换左右结点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    /**
     * 11.找出二叉树中第一个（相距最近）大于中间值的结点
     *
     * @param root 根结点
     * @return 树中第一个大于中间值的结点
     */
    public static TreeNode getNode(TreeNode root) {
        TreeNode maxNode = getMaxNode(root);
        TreeNode minNode = getMinNode(root);

        // 中间值
        int mid = minNode.data + (maxNode.data - minNode.data) / 2;

        TreeNode result = null;
        while (root != null) {
            // 当前结点的值不大于f，则在右子树找
            if (root.data <= mid) {
                root = root.right;
            }
            // 当前结点的值大于f，则在左子树找
            else {
                // 先赋值给result, 防止root没有左子树
                result = root;
                root = root.left;
            }
        }
        return result;
    }

    /**
     * 查找二叉树的最小值结点
     *
     * @param root 根结点
     * @return 最小值结点
     */
    private static TreeNode getMinNode(TreeNode root) {
        // 递归
//        if (root.left == null) {
//            return root;
//        }
//        return getMinNode(root.left);

        // 迭代
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * 查找二叉树的最大值结点
     *
     * @param root 根结点
     * @return 最大值结点
     */
    private static TreeNode getMaxNode(TreeNode root) {
        // 递归
        if (root.right == null) {
            return root;
        }
        return getMaxNode(root.right);

        // 迭代
//        if (root == null) {
//            return null;
//        }
//        while (root.right != null) {
//            root = root.right;
//        }
//        return root;
    }

    /**
     * 12.找出二叉树中路径最大的和，路径可以以任意结点作为起点和终点
     *
     * @param root 根结点
     * @return 路径最大和
     */
    public static int findMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            // 求左子树以root.left为起始结点的最大路径和
            int sumLeft = findMaxPath(root.left);
            // 求右子树以root.right为起始结点的最大路径和
            int sumRight = findMaxPath(root.right);

            /*
                求以root为起始结点，叶子结点为结束结点的最大路径和
                包含root结点的最长路径可能包含如下三种情况：
                (1) leftMax = root.data + sumLeft (右子树最大路径和可能为负)
                (2) rightMax = root.data + sumRight (左子树最大路径和可能为负)
                (3) allMax = root.data + sumLeft + sumRight (左右子树最大路径和都不为负)
             */

            int leftMax = root.data + sumLeft;
            int rightMax = root.data + sumRight;
            int allMax = root.data + sumLeft + sumRight;
            int tmpMax = Max(allMax, leftMax, rightMax);
            if (tmpMax > maxSum2) {
                maxSum2 = tmpMax;
            }

            // subMax表示左子树和右子树最大值
            int subMax = Math.max(sumLeft, sumRight);
            return root.data + subMax;
        }
    }

    /**
     * 求三个数中最大数
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    private static int Max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        // 1.把有序数组转换成二叉树
        /*
                       6
                   /       \
                  3         9
                 / \       / \
                2   5     8  10
               /   /     /
              1   4     7
         */
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("数组：");
        System.out.print(Arrays.toString(arr));
        System.out.println();

        TreeNode root = arrayToTree(arr, 0, arr.length - 1);
        System.out.print("转换成树的中序遍历为：");
        inOrder(root);
        System.out.println();

        // 2.层序遍历
        System.out.print("树的层序遍历为：");
        levelOrder(root);
        System.out.println();

        // 3.求最大子树和
        TreeNode maxRoot = new TreeNode();
        findMaxSubTree(root, maxRoot);
        System.out.println("最大子树和为：" + maxSum);
        System.out.println("对应子树的根节点为：" + maxRoot.data);

        // 5.将二叉树转换成排好序的双向链表
        treeToLinkedList(root);
        System.out.print("转换后双向链表正向遍历：");
        TreeNode cur;
        for (cur = pHead; cur != null; cur = cur.right) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
        System.out.print("转换后双向链表反向遍历：");
        for (cur = pEnd; cur != null; cur = cur.left) {
            System.out.print(cur.data + " ");
        }
        System.out.println();

        // 6.判断一个数组是否是二叉树的后序遍历的序列
        int[] arr6 = {1, 3, 2, 5, 7, 6, 4};
        boolean result = isAfterOrder(arr6, 0, arr6.length - 1);
        for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i] + " ");
        }
        if (result) {
            System.out.println("是二叉树的后序遍历序列");
        } else {
            System.out.println("不是二叉树的后序遍历序列");
        }

        // 7.求两个结点的最近公共父结点
        int[] arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root7 = arrayToTree(arr7, 0, arr7.length - 1);
        TreeNode node1 = root7.left.left.left;
        TreeNode node2 = root7.left.right;
        TreeNode commonParentNode = findParentNode2(root7, node1, node2);
        if (commonParentNode != null) {
            System.out.println(node1.data + "与" + node2.data + "的最近公共父结点为：" + commonParentNode.data);
        } else {
            System.out.println("没有公共父结点");
        }

        // 9.找出所有路径满足：这条路径上的所有结点数据和等于给定的整数
        int[] arr9 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root9 = arrayToTree(arr9, 0, arr9.length - 1);
        List<Integer> list = new ArrayList<>();
        System.out.print("满足路径结点和等于8的路径为：");
        findRoad(root9, 25, 0, list);

        // 10.对二叉树镜像反转
        int[] arr10 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root10 = arrayToTree(arr10, 0, arr10.length - 1);
        System.out.print("树的层序遍历为：");
        levelOrder(root10);
        System.out.println();
        reverseTree(root10);
        System.out.print("反转后的树的层序遍历为：");
        levelOrder(root10);
        System.out.println();

        // 11.找出二叉树中第一个（相距最近）大于中间值的结点
        int[] arr11 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root11 = arrayToTree(arr11, 0, arr11.length - 1);
        System.out.println("第一个（相距最近）大于中间值的结点：" + getNode(root11).data);

        // 12.找出二叉树中路径最大的和，路径可以以任意结点作为起点和终点
        int[] arr12 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root12 = arrayToTree(arr12, 0, arr12.length - 1);
        findMaxPath(root12);
        System.out.println("最大路径和：" + maxSum2);  // 42
    }
}
