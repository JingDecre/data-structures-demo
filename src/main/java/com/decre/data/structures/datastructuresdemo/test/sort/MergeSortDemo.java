package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.MergeSort;

/**
 * @Author: Liaofuan
 * @Description: 归并排序
 * @Date: Created at 下午 02:30:42 2021年2月24日 0024
 * @Modified by:
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort(8000000);
        mergeSort.randomInit();
        mergeSort.sort();
        //mergeSort.printList();
    }
}
