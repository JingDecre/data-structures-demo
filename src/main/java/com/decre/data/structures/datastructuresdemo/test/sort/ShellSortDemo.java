package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.ShellSort;
import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

/**
 * @Author: Liaofuan
 * @Description: 希尔排序
 * @Date: Created at 上午 08:15:03 2021年2月23日 0023
 * @Modified by:
 */
public class ShellSortDemo {

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int[] arr = ArrayUtils.randomInit(30000);
//        sort.exchangeSort(arr);
        sort.displacementSort(arr);
       // sort.printList();

    }
}
