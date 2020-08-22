package 分类刷题.数组;

/**
 * 求数组连续最大和
 * 比如{1, -2, 4, 8, -4, 7, -1, -5}，最大和子数组为{4, 8, -4, 7}，最大值为15
 */
public class Case5 {

    public static void main(String[] args) {
        int[] arr = {1, -2, 4, 8, -4, 7, -1, -5};
        System.out.println("method1连续最大和为：" + method1(arr));
        System.out.println("method2连续最大和为：" + method2(arr));
        System.out.println("method3连续最大和为：" + method3(arr));
    }

    /**
     * 暴力三重遍历 O(n^3)
     *
     * @param arr
     * @return
     */
    public static int method1(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("参数不合法");
            return -1;
        }

        int curSum = 0;
        int maxSum = 0;
        // 控制从第几个数字开始算连续和
        for (int i = 0; i < arr.length; i++) {
            // 控制连续的数字有多少个
            for (int j = i; j < arr.length; j++) {
                curSum = 0;
                // 将连续的数字逐个相加
                for (int k = i; k < j; k++) {
                    curSum += arr[k];
                }
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 重复利用已经计算的子数组和（记忆化搜索） O(n^2)
     *
     * @param arr
     * @return
     */
    public static int method2(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("参数不合法");
            return -1;
        }

        int sum = 0;
        int maxSum = 0;
        // 控制从第几个数字开始算连续和
        for (int i = 0; i < arr.length; i++) {
            //新的一轮需要清零
            sum = 0;
            // 控制连续的数字有多少个
            for (int j = i; j < arr.length; j++) {
               /* curSum = 0;
                // 将连续的数字逐个相加
                for (int k = i; k < j; k++) {
                    curSum += arr[k];
                }*/
                //不用每次都重复计算了
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 动态规划 O(n)
     *
     * @param arr
     * @return
     */
    public static int method3(int[] arr) {
        return 0;
    }
}
