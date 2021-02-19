package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.InsertionSort;

/**
 * @Author: Liaofuan
 * @Description: 插入排序
 * @Date: Created at 下午 04:36:34 2021年2月19日 0019
 * @Modified by:
 */
public class InsertionSortDemo {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort(30000);
        insertionSort.randomInit();
        insertionSort.sort();
        insertionSort.printList();
    }
}
