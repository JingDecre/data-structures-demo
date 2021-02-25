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

    /**
     * 插入排序
     */
    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        for (int i = 1; i < arr.length; i++) {
            // 假设第一个下标为最小下标
            int insertIndex = i - 1;
            // 假设第二个值为最小值
            int insertVal = arr[i];
            // 遍历已排序好的数组，找到需要插入数据的下标位置，并将该下标及之后的数据统统后移一位，为即将插入的数据，空出位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                // 大值后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 不等i时，说明需要插入数据
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
    public void printList(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(" " + i));
        System.out.println();
    }

}
