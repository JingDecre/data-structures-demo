package com.decre.data.mathematics.mathematicsdemo.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @className: CoinsDemo
 * @description: 凑硬币问题
 * @author: decre
 * @date: 2021/3/2
 **/
public class CoinsDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
//        System.out.println(minCount1(arr, 17));
        System.out.println(minCount2(arr, 45));
        System.out.println(minCount3(arr, 45));
    }

    /**
     * 暴力递归
     * @param arr
     * @param amount
     * @return
     */
    private static int minCount1(int[] arr, int amount) {
        return dp1(arr, amount);
    }

    /**
     * 暴力递归方法
     *
     * @param arr
     * @param amount
     * @return
     */
    private static int dp1(int[] arr, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin: arr) {
            int subMinCount = dp1(arr, amount - coin);
            if (subMinCount < 0) continue;
            res = Math.min(subMinCount + 1, res);
        }
        if (Integer.MAX_VALUE != res) {
            return res;
        }
        return -1;
    }

    /**
     * 带备忘录递归
     * @param arr
     * @param amount
     * @return
     */
    private static int minCount2(int[] arr, int amount) {
        Map<Integer, Integer> minMap = new HashMap<>();
        return dp2(minMap, arr, amount);
    }

    /**
     * 备忘录递归方法
     *
     * @param arr
     * @param amount
     * @return
     */
    private static int dp2(Map<Integer, Integer> minMap,int[] arr, int amount) {
        if (minMap.containsKey(amount)) {
            return minMap.get(amount);
        }
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin: arr) {
            int subMinCount = dp2(minMap, arr, amount - coin);
            if (subMinCount < 0) continue;
            res = Math.min(subMinCount + 1, res);
        }
        if (Integer.MAX_VALUE != res) {
            minMap.put(amount, res);
            return res;
        }
        return -1;
    }

    /**
     * dp数组解法
     *
     * @param arr
     * @param amount
     * @return
     */
    private static int minCount3(int[] arr, int amount) {
        return dp3(arr, amount);
    }

    /**
     * dp数组核心逻辑
     *
     * @param coins
     * @param amount
     * @return
     */
    private static int dp3(int[] coins, int amount) {
        int[] minArr = new int[amount + 1];
        Arrays.fill(minArr, amount + 1);
        // base case
        minArr[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < minArr.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin: coins) {
                // 子问题无解，跳过
                if (i- coin < 0) continue;

                minArr[i] = Math.min(minArr[i], 1 + minArr[i - coin]);
            }
        }
        return  (minArr[amount] == amount + 1) ? -1: minArr[amount];
    }
}
