package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.SelectSort;
import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

/**
 * @Author: Liaofuan
 * @Description: 选择排序demo
 * @Date: Created at 下午 02:48:29 2021年2月19日 0019
 * @Modified by:
 */
public class SelectSortDemo {

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        int[] arr = ArrayUtils.randomInit(30000);
        sort.sort(arr);
        sort.printList(arr);
    }
}
