package com.decre.data.structures.datastructuresdemo.test.search;

import com.decre.data.structures.datastructuresdemo.service.search.SeqSearch;
import com.decre.data.structures.datastructuresdemo.util.ArrayUtils;

import java.util.Arrays;

/**
 * @Author: Liaofuan
 * @Description:  线性查找
 * @Date: Created at 下午 02:54:05 2021年2月25日 0025
 * @Modified by:
 */
public class SeqSearchDemo {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.randomInit(30);
        SeqSearch seqSearch = new SeqSearch();
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(seqSearch.search(arr, 1));
    }
}
