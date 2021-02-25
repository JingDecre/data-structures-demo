package com.decre.data.structures.datastructuresdemo.util;

import java.util.stream.IntStream;

/**
 * @Author: Liaofuan
 * @Description: 数组工具
 * @Date: Created at 上午 10:25:15 2021年2月25日 0025
 * @Modified by:
 */
public class ArrayUtils {

    /**
     * 随机初始化数据
     */
    public static int[] randomInit(int size) {
        int[] arr = new int[size];
        IntStream.range(0, size).forEach(i -> arr[i] = (int) (Math.random() * size));
        return arr;
    }
}
