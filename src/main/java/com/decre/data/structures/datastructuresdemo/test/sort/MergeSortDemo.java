package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.MergeSort;
import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

/**
 * @Author: Liaofuan
 * @Description: 归并排序
 * @Date: Created at 下午 02:30:42 2021年2月24日 0024
 * @Modified by:
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = ArrayUtils.randomInit(8000000);
        sort.sort(arr);
        //sort.printList();
    }
}
