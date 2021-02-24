package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.ShellSort;

/**
 * @Author: Liaofuan
 * @Description: 希尔排序
 * @Date: Created at 上午 08:15:03 2021年2月23日 0023
 * @Modified by:
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort(80000);
        shellSort.randomInit();
        // 交换排序
        // shellSort.exchangeSort();
        // 位移排序
        shellSort.displacementSort();
        shellSort.printList();

    }
}
