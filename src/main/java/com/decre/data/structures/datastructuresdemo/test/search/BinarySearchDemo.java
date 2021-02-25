package com.decre.data.structures.datastructuresdemo.test.search;

import com.decre.data.structures.datastructuresdemo.service.search.BinarySearch;
import com.decre.data.structures.datastructuresdemo.service.sort.QuickSort;
import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Liaofuan
 * @Description: 二分查找法
 * @Date: Created at 下午 04:16:13 2021年2月25日 0025
 * @Modified by:
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.randomInit(60);
        BinarySearch search = new BinarySearch();
        QuickSort sort = new QuickSort();
        sort.sort(arr);
        sort.printList(arr);
        System.out.println();
        long start = System.currentTimeMillis();
        // 返回单个结果
        int index = search.singleSearch(arr, 0, arr.length - 1, 3);
        long end = System.currentTimeMillis();
        System.out.printf("数组大小[%d]总共耗时:[%d],结果下标[%d]", arr.length, (end - start), index);
        System.out.println();
        start = System.currentTimeMillis();
        List<Integer> searchResultList = search.listSearch(arr, 0, arr.length - 1, 5);
        end = System.currentTimeMillis();
        System.out.printf("数组大小[%d]总共耗时:[%d],结果下标%s", arr.length, (end - start), searchResultList.toString());
    }
}
