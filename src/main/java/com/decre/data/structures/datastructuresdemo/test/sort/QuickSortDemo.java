package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.QuickSort;

/**
 * @Author: Liaofuan
 * @Description: 快速排序
 * @Date: Created at 上午 08:40:19 2021年2月24日 0024
 * @Modified by:
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort(8000000);
        quickSort.randomInit();
        quickSort.sort();
    }
}
