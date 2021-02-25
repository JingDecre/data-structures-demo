package com.decre.data.structures.datastructuresdemo.service.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: Liaofuan
 * @Description: 选择排序
 * @Date: Created at 下午 02:00:40 2021年2月19日 0019
 * @Modified by:
 */
public class SelectSort {


    /**
     * 选择排序
     */
    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
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
    public void printList(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(" " + i));
        System.out.println();
    }

}
