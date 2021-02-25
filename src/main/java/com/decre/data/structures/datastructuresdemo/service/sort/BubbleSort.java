package com.decre.data.structures.datastructuresdemo.service.sort;

import lombok.Data;

import java.util.Arrays;

/**
 * @Author: Liaofuan
 * @Description: 冒泡排序
 * @Date: Created at 下午 04:35:11 2021年2月18日 0018
 * @Modified by:
 */
@Data
public class BubbleSort {

    /**
     * 冒泡排序
     */
    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("Bubble start timestamp:" + start);
        Boolean flag = Boolean.FALSE;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length -1 -i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = Boolean.TRUE;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // 在一趟排序中，一次交换都没有发生过
            if (!flag) {
                break;
            } else { // 重置 flag!!!, 进行下次判断
                flag = false;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Bubble end timestamp:" + end + ", the time difference: " + (end - start) + "ms");
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
