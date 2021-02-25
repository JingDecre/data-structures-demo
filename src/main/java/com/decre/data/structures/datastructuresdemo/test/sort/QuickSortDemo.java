package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.QuickSort;
import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

/**
 * @Author: Liaofuan
 * @Description: 快速排序
 * @Date: Created at 上午 08:40:19 2021年2月24日 0024
 * @Modified by:
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] arr = ArrayUtils.randomInit(8000000);
        sort.sort(arr);
    }
}
