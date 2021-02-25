package com.decre.data.structures.datastructuresdemo.service.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: Liaofuan
 * @Description: 归并排序
 * @Date: Created at 上午 10:43:47 2021年2月23日 0023
 * @Modified by:
 */
public class MergeSort {

    /**
     * 开始排序
     */
    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        int[] tempArr = new int[arr.length];
        mergeSort(arr,0, arr.length - 1, tempArr);
        long end = System.currentTimeMillis();
        System.out.println("Select sort end:" + start + ", the time difference: " + (end - start) + " ms");
    }

    /**
     * 快速排序
     *
     * @param left
     * @param right
     */
    private void mergeSort(int[] arr,int left, int right, int[] tempArr) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归
            mergeSort(arr, left, mid, tempArr);
            // 向右递归
            mergeSort(arr,mid + 1, right, tempArr);
            // 合并左右已排列好的数据
            merge(arr, left, mid, right, tempArr);
        }

    }

    /**
     * 合并
     *
     * @param left
     * @param mid
     * @param right
     * @param tempArr
     */
    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        // 左侧起始下标
        int i = left;
        // 右侧起始下标
        int j = mid + 1;
        // tempArr临时下标
        int t = 0;
        //先把左右两边(有序)的数据按照规则填充到 temp 数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到 temp 数组
            //然后 t++, i++
            if (arr[i] <= arr[j]) {
                tempArr[t] = arr[i];
                i += 1;
                t += 1;
            } else {
                tempArr[t] = arr[j];
                j += 1;
                t += 1;
            }
        }
        //左边的有序序列还有剩余的元素，就全部填充到 temp
        while (i <= mid) {
            tempArr[t] = arr[i];
            i += 1;
            t += 1;
        }
        //右边的有序序列还有剩余的元素，就全部填充到 temp
        while (j <= right) {
            tempArr[t] = arr[j];
            j += 1;
            t += 1;
        }

        t = 0;
        int tempLeft = left;
        // 将临时数组tempArr值赋值到原始数组arr
        while (tempLeft <= right) {
            arr[tempLeft] = tempArr[t];
            t += 1;
            tempLeft += 1;
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
