package com.decre.data.structures.datastructuresdemo.service.search;

/**
 * @Author: Liaofuan
 * @Description: 线性搜索
 * @Date: Created at 下午 02:50:39 2021年2月25日 0025
 * @Modified by:
 */
public class SeqSearch {

    /**
     * 返回数据对应的下标
     *
     * @param arr
     * @param val
     * @return
     */
    public int search(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
