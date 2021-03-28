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
        if (amount == 0) return amount;
        int[] array = new int[amount + 1];
        Arrays.fill(array, amount + 1);
        // base case
        array[0] = 0;
        // 数组下标表示金额，对应的value表示需要的硬币个数
        for (int i = 1; i < amount + 1; i++) {
            for (int coin: coins) {
                // 负数无意义，跳过
                if (i - coin < 0) continue;
                // 距离当前i下标（金额）间隔coin步数的最少硬币数
                int temp = array[i - coin];
                array[i] = Math.min(array[i], temp + 1);
            }
        }

        return (array[amount] == amount + 1) ? -1 : array[amount];

    }
}
