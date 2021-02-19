package com.decre.data.structures.datastructuresdemo.service.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: Liaofuan
 * @Description:
 * @Date: Created at 下午 02:00:40 2021年2月19日 0019
 * @Modified by:
 */
public class SelectSort {
    private int maxSize;

    private int[] arr;

    public SelectSort(int maxSize) {
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
     * 选择排序
     */
    public void sort() {
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        for (int i = 0; i < maxSize - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < maxSize; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            // 下标不等，说明有进行过交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Select sort end:" + start + ", the time difference: " + (end - start) + " ms");

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
