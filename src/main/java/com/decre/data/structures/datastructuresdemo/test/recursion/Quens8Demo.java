package com.decre.data.structures.datastructuresdemo.test.recursion;

import com.decre.data.structures.datastructuresdemo.service.recursion.Quens8;

/**
 * @className: Quens8
 * @description: 用递归解决八皇后问题
 * @author: decre
 * @date: 2021/1/27
 **/
public class Quens8Demo {

    public static void main(String[] args) {
        Quens8 quens8 = new Quens8(8);
        quens8.check(0);
        System.out.printf("一共有%d 解法", quens8.getCount());
        System.out.printf("一共判断冲突的次数%d 次", quens8.getConflictCount());
    }
}
