package com.decre.data.structures.datastructuresdemo.service.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: Liaofuan
 * @Description: 插入排序
 * @Date: Created at 下午 02:54:47 2021年2月19日 0019
 * @Modified by:
 */
public class InsertionSort {

    private int maxSize;

    private int[] arr;

    public InsertionSort(int maxSize) {
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
     * 插入排序
     */
    public void sort() {
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        for (int i = 1; i < maxSize; i++) {
            int insertIndex = i - 1;
            int insertVal = arr[i];
            // 找到最小值该插入的下标位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 插入数据
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
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
