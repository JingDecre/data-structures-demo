package com.decre.data.structures.datastructuresdemo.test.sort;

import com.decre.data.structures.datastructuresdemo.service.sort.BubbleSort;
import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

/**
 * @Author: Liaofuan
 * @Description:
 * @Date: Created at 下午 05:26:37 2021年2月18日 0018
 * @Modified by:
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] arr = ArrayUtils.randomInit(30000);
        sort.sort(arr);
        sort.printList(arr);
    }
}
