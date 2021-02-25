package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.InsertionSort;
import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

/**
 * @Author: Liaofuan
 * @Description: 插入排序
 * @Date: Created at 下午 04:36:34 2021年2月19日 0019
 * @Modified by:
 */
public class InsertionSortDemo {

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] arr = ArrayUtils.randomInit(30000);
        sort.sort(arr);
        sort.printList(arr);
    }
}
