package com.decre.data.structures.datastructuresdemo.service.recursion;

import lombok.Data;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @className: Quens8
 * @description: 八皇后问题具体实现类
 * @author: decre
 * @date: 2021/1/27
 **/
public class Quens8 {

    //定义一个 max 表示共有多少个皇后
    private int max;

    //定义数组 array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    private int[] array;

    /**
     * 组合情况总数
     */
    private int count;

    /**
     * 遇到的冲突数
     */
    private int conflictCount;

    public Quens8(int max) {
        this.max = max;
        array = new int[max];
    }

    public int getCount() {
        return count;
    }

    public int getConflictCount() {
        return conflictCount;
    }

    public void check(int n) {
        // 当八皇后位置已得出，结束递归，输出排列
        if (max == n) {
            print();
            return;
        }

        IntStream.range(0, max).forEach(i -> {
            // 依次放入皇后
            array[n] = i;
            // 判断是否与下标n以前的皇后位置冲突
            if (!conflict(n)) {
                check(n + 1);
            }
        });
    }

    /**
     * 查看当我们放置第 n 个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
     *
     * @param n 表示第 n 个皇后
     * @return
     */
    private boolean conflict(int n) {
        conflictCount++;
        // 说明
        //1. array[i] == array[n] 表示判断 第 n 个皇后是否和前面的 n-1 个皇后在同一列
        //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第 n 个皇后是否和第 i 皇后是否在同一斜线

        // n = 1 放置第 2 列 1 n = 1 array[1] = 1
        // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
        //3. 判断是否在同一行, 没有必要，n 每次都在递增
       return IntStream.range(0, n).anyMatch(i -> array[i] == array[n] || Math.abs(n -i) == Math.abs(array[n] - array[i]));
    }

    /**
     * 当产生八皇后时，输出对应的排列位置
     */
    private void print() {
        count++;
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
