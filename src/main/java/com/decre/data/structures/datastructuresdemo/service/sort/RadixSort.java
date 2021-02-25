package com.decre.data.structures.datastructuresdemo.service.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: Liaofuan
 * @Description: 基数排序
 * @Date: Created at 上午 10:43:47 2021年2月23日 0023
 * @Modified by:
 */
public class RadixSort {

    /**
     * 开始排序
     */
    public void sort(int[] arr) {
        long start = System.currentTimeMillis();
        System.out.println("Select sort start:" + start);
        //quickSort(0, arr.length - 1);
        radixSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Select sort end:" + start + ", the time difference: " + (end - start) + " ms");
    }

    /**
     * 基数排序
     *
     */
    private void radixSort(int[] arr) {
       if (arr.length > 0) {
           // 假定第一个数是最大数
           int max = arr[0];
           // 遍历原始数组获取最大数
           for (int i = 0; i < arr.length; i++) {
               if (arr[i] > max) {
                   max = arr[i];
               }
           }
            // 获取最大数的位数
           int length = (max + "").length();

           // 1、10表示桶的数量
           // 2、每个桶大小为arr.length，即原始数组大小，为了预防下标溢出
           // 3、明确基数排序是空间换时间的算法
           int[][] bucket = new int[10][arr.length];
           // 每个桶的数据量大小
           int[] bucketCounts = new int[10];
           // 遍历位数，个位、十位、百位...都按照对应位数的余数给桶填充值
           for (int i = 0, n=1; i < length; i++, n *= 10) {

               for (int j = 0; j < arr.length; j++) {
                   // 取余，定位桶的下标位置
                   int bucketIndex = arr[j] / n % 10;
                   // 给对应桶新增数据
                   bucket[bucketIndex][bucketCounts[bucketIndex]] = arr[j];
                   // 桶的数据量自增1
                   bucketCounts[bucketIndex]++;
               }

               int index = 0;
               // 遍历桶
               for (int k = 0; k < 10; k++) {
                   // 桶里面有数据
                   if (bucketCounts[k] != 0) {
                       for (int j = 0; j < bucketCounts[k]; j++) {
                           arr[index++] = bucket[k][j];
                       }
                   }
                   // 每个桶遍历完，对应的数据量大小数据需要清0，为了下一次升位（个位进十位，十进百）可以重新使用
                   bucketCounts[k] = 0;
               }
           }
       }
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
