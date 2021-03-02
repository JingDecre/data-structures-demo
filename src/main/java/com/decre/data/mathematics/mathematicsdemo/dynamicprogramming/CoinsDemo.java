package com.decre.data.mathematics.mathematicsdemo.dynamicprogramming;

/**
 * @className: CoinsDemo
 * @description: 凑硬币问题
 * @author: decre
 * @date: 2021/3/2
 **/
public class CoinsDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        System.out.println(minCount(arr, 17));

    }

    /**
     * 暴力递归
     * @param arr
     * @param amount
     * @return
     */
    private static int minCount(int[] arr, int amount) {
        return dp(arr, amount);
    }

    /**
     * 暴力递归方法
     *
     * @param arr
     * @param amount
     * @return
     */
    private static int dp(int[] arr, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin: arr) {
            int subMinCount = dp(arr, amount - coin);
            if (subMinCount < 0) continue;
            res = Math.min(subMinCount + 1, res);
        }
        if (Integer.MAX_VALUE != res) {
            return res;
        }
        return -1;
    }
}
