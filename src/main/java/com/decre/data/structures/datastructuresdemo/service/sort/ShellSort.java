package com.decre.data.structures.datastructuresdemo.service.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: Liaofuan
 * @Description: 希尔排序
 * @Date: Created at 下午 04:55:25 2021年2月22日 0022
 * @Modified by:
 */
public class ShellSort {

    private int maxSize;

    private int[] arr;

    public ShellSort(int maxSize) {
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
     * 交换法希尔排序
     */
    public void exchangeSort() {
//        int count = 0;
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        // 分组
        for (int gap = maxSize / 2; gap > 0; gap /= 2) {
            // 遍历组
            for (int i = gap; i < maxSize; i++) {
                // 遍历组中的元素,gap为步长
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }

                }

            }
//            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
        long end = System.currentTimeMillis();
        System.out.println("Select sort end:" + start + ", the time difference: " + (end - start) + " ms");
    }

    /**
     * 位移法希尔排序
     *
     */
    public void displacementSort() {
//        int count = 0;
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        // 分组
        for (int gap = maxSize / 2; gap > 0; gap /= 2) {
            // 遍历组
            for (int i = gap; i < maxSize; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                }
                arr[j] = temp;
            }
//            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
        long end = System.currentTimeMillis();
        System.out.println("Select sort end:" + start + ", the time difference: " + (end - start) + " ms");
    }

    /**
     * 打印数组
     */
    public void printList() {
        Arrays.stream(arr).forEach(i -> System.out.print(" " + i));
        System.out.println();
    }

}
