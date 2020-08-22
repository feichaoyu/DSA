package 分类刷题.数组;

/**
 * 求解数组中两个元素的最小距离
 * 给定义一个数组，数组中含有重复元素，给定两个数字num1和num2，求这两个数字在数组中出现的位置的最小距离
 */
public class Case4 {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8};
        int num1 = 4;
        int num2 = 8;
        System.out.println(method1(arr, num1, num2));
        System.out.println(method2(arr, num1, num2));
    }

    /**
     * 思路：双层遍历 O(n^2)
     * 外层循环遍历查找num1，只要找到 num1，内层循环从头开始遍历查找num2，
     * 找到num2就计算它和num1之间的距离，最终找出最小距离。
     *
     * @param arr
     * @param num1
     * @param num2
     * @return
     */
    private static int method1(int[] arr, int num1, int num2) {
        // 设置为最大值，而不是0，方便判断
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num1) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == num2) {
                        // 当前遍历的num1和num2的距离
                        int dist = Math.abs(i - j);
                        if (minDist > dist) {
                            minDist = dist;
                        }
                    }
                }
            }
        }
        return minDist;
    }

    /**
     * 思路：动态规划 O(n)
     * 方法一中内层循环对num2的位置进行了很多次重复的查找。采用动态规划的方法可以把每次遍历的结果都记录下来，从而减少遍历次数。
     * 遍历数组会遇到以下两种情况：
     * 1.遇到num1时，记录下num1值对应的数组下标的位置lastPos1，通过对lastPos1与上次遍历到num2下标位置的值lastPos2的差
     * 可以求出最近一次遍历到的num1和num2的距离。
     * 2.当遇到num2时，同样记录下它在数组中下标的位置lastPos2，然后通过求lastPos2与上次遍历到num1的下标值lastPos1，
     * 求出最近一次遍历到的num1和num2的距离。
     * 假设给定数组为：{4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8}，num1=4，num2=8
     * 执行过程如下：
     * 1.在遍历时首先遍历到4，下标为lastPos1=0，由于此时还没有遍历到num2，因此没必要计算num1和num2的最小距离
     * 2.接着遍历，又遍历到num1=4，更新lastPos1=3
     * 3.接着遍历，又遍历到num1=4，更新lastPos1=5
     * 4.接着遍历，又遍历到num1=4，更新lastPos1=7
     * 5.接着遍历，又遍历到num2=8，更新lastPos2=9，此时由于前面已经遍历到过num1，因此可以求出num1与num2的最小距离为2
     * 6.接着遍历，又遍历到num1=4，更新lastPos1=12，此时由于前面已经遍历到过num2，因此可以求出num1与num2的最小距离为3，由于3>2，因此最小距离为2
     * 7.接着遍历，又遍历到num2=8，更新lastPos2=15，此时由于前面已经遍历到过num1，因此可以求出num1与num2的最小距离为8，由于8>2，因此最小距离为2
     *
     * @param arr
     * @param num1
     * @param num2
     * @return
     */
    private static int method2(int[] arr, int num1, int num2) {
        if (arr == null || arr.length <= 0) {
            System.out.println("参数不合法");
            return Integer.MAX_VALUE;
        }

        int lastPos1 = -1;
        int lastPos2 = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num1) {
                lastPos1 = i;
                if (lastPos2 >= 0) {
                    minDis = Math.min(minDis, lastPos1 - lastPos2);// 不需要绝对值
                }
            }
            if (arr[i] == num2) {
                lastPos2 = i;
                if (lastPos1 >= 0) {
                    minDis = Math.min(minDis, lastPos2 - lastPos1);// 不需要绝对值
                }
            }
        }
        return minDis;
    }
}
