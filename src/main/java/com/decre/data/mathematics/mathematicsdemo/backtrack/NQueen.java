package com.decre.data.mathematics.mathematicsdemo.backtrack;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @className: NQueen
 * @description: 回溯法解决N皇后问题
 * @author: decre
 * @date: 2021/3/9
 **/
public class NQueen {

    public static void main(String[] args) {
        List<int[]> list = solveNQueens(8);
        System.out.println(list.size());
        list.forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });
    }

    /**
     * n皇后入口
     *
     * @param n n*n的方格
     * @return
     */
    private static List<int[]> solveNQueens(int n) {
        List<int[]> list = new LinkedList<>();
        // 下标表示行，值表示列
        int[] solveIndex = new int[n];
        Arrays.fill(solveIndex, -1);
        // 用回溯法进行递归
        backtrack(list, solveIndex, 0);
        return list;
    }

    private static void backtrack(List<int[]> result, int[] queenSort, int n) {
        if (n == queenSort.length) {
            result.add(Arrays.copyOf(queenSort, n));
            return;
        }
        for (int i = 0; i < queenSort.length; i++) {
            //
            queenSort[n] = i;
            // 回溯，判断是否上下左右和斜线方向是否已存在皇后
            // 当两个皇后处于同一斜线时，两个皇后的横坐标之差与纵坐标之差是相等的 即 |n - j| (横坐标之差) 和 |queenSort[n] - queenSort[j]| （纵坐标之差） 相等
            boolean flag = IntStream.range(0, n).anyMatch(j -> queenSort[j] == queenSort[n] || Math.abs(n - j) == Math.abs(queenSort[n] - queenSort[j]));
            if (!flag) {
                backtrack(result, queenSort, n + 1);
            }

        }
    }
}
