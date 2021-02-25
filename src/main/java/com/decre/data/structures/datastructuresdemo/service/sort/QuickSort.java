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

    /**
     * 开始排序
     */
    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("Select sort end:" + start + ", the time difference: " + (end - start) + " ms");
    }

    /**
     * 快速排序
     *
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // 中轴值
        int pivot = arr[(left + right) / 2];
        // 交换时使用
        int temp;
        //while 循环的目的是让比 pivot 值小放到左边
        //比 pivot 值大放到右边
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            // 当左下标大于等于右下标跳出循环
            if (l >= r) {
                break;
            }
            // 能被交换，说明 arr[l] >= pivot, arr[r] <= pivot
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                //!!!! 不是l++，而是r--
                r--;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                //!!!! 不是r--，而是l++
                l++;
            }
        }
        // 如果 l == r, 必须 l++, r--, 否则为出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (l < right) {
            quickSort(arr, l, right);
        }
    }

    /**
     * 打印数组
     */
    public void printList(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(" " + i));
        System.out.println();
    }
}
