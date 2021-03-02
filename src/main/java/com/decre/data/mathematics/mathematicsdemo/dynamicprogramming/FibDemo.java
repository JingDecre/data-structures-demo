package com.decre.data.mathematics.mathematicsdemo.dynamicprogramming;

/**
 * @className: FibDemo
 * @description: 斐波那契数列
 * @author: decre
 * @date: 2021/3/2
 **/
public class FibDemo {

    public static void main(String[] args) {
        //System.out.println(fib1(45));
        System.out.println(fib2(30));
        System.out.println(fib3(30));

    }

    /**
     * 暴力递归
     *
     * @param n
     * @return
     */
    private static long fib1(int n) {
        long start = System.currentTimeMillis();
        long result = calc1(n);
        System.out.printf("暴力递归结果：%d,共花费：%d ms \n",result, System.currentTimeMillis() - start);
        return result;
    }
    /**
     * 暴力递归核心计算逻辑
     *
     * @param i
     * @return
     */
    private static long calc1(int i) {
        if (i == 1 || i == 2) return 1;
        return calc1(i - 1) + calc1(i - 2);

    }
    
    

    /**
     * 带备忘录的递归
     *
     * @param n
     * @return
     */
    private static long fib2(int n) {
        long start = System.currentTimeMillis();
        if (n < 1) return 0;
        // 数组下标从0开始，所以多给一位空间
        long[] dictionary = new long[n + 1];
        long result = calc2(dictionary, n);
        System.out.printf("备忘录递归结果：%d,共花费：%d ms \n",result, System.currentTimeMillis() - start);
        return result;
    }

    /**
     * 备忘录递归核心计算方法
     *
     * @param dictionary
     * @param n
     * @return
     */
    private static long calc2(long[] dictionary, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (dictionary[n] != 0) return dictionary[n];
        dictionary[n] = calc2(dictionary, n -1) + calc2(dictionary, n -2);
        return dictionary[n];
    }

    /**
     * 使用dp数组迭代方法求解
     *
     * @param n
     * @return
     */
    private static long fib3(int n) {
        long start = System.currentTimeMillis();
        long[] dp = new long[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.printf("dp求解结果：%d,耗时: %d ms \n", dp[n], System.currentTimeMillis() - start);
        return dp[n];
    }
}
