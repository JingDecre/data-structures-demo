package com.decre.data.structures.datastructuresdemo.service.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: Liaofuan
 * @Description: 快速排序
 * @Date: Created at 上午 10:43:47 2021年2月23日 0023
 * @Modified by:
 */
public class QuickSort {

    private int maxSize;

    private int[] arr;

    public QuickSort(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 随机初始化数据
     */
    public void randomInit() {
        IntStream.range(0, maxSize).forEach(i -> arr[i] = (int) (Math.random() * maxSize));
    }

    /**
     * 打印数组
     *
     */
    public void printList() {
        Arrays.stream(arr).forEach(i -> System.out.print(" " + i));
        System.out.println();
    }
}
