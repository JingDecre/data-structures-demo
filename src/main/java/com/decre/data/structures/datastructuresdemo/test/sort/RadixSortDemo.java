package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.RadixSort;

/**
 * @Author: Liaofuan
 * @Description: 基数排序
 * @Date: Created at 上午 10:02:03 2021年2月25日 0025
 * @Modified by:
 */
public class RadixSortDemo {

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort(8000000);
        radixSort.randomInit();
        radixSort.sort();
    }
}
