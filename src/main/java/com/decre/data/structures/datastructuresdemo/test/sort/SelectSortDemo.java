package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.SelectSort;

/**
 * @Author: Liaofuan
 * @Description: 选择排序demo
 * @Date: Created at 下午 02:48:29 2021年2月19日 0019
 * @Modified by:
 */
public class SelectSortDemo {

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort(30000);
        selectSort.randomInit();
        selectSort.sort();
        selectSort.printList();

    }
}
