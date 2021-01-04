package com.decre.data.structures.datastructuresdemo.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        int array1[][] = new int[8][8];
        // 初始化数据
        array1[1][2] = 1;
        array1[5][6] = 2;
        array1[4][7] = 2;
        // 打印原有二维数组，并统计个数
        System.out.println("原二维数组~~");
        for (int[] row : array1) {
            for (int cel : row) {
                System.out.printf("%d\t", cel);
            }
            System.out.println();
        }
        // 统计有效数据个数
        long sum = IntStream.range(0, 8).filter(i -> IntStream.range(0, 8).anyMatch(j -> array1[i][j] != 0)).count();
        System.out.printf("有效数据个数: %d\n", sum);

        int sparseArray[][] = new int[(int) sum + 1][3];
        sparseArray[0][0] = 8; // 几行
        sparseArray[0][1] = 8; // 几列
        sparseArray[0][2] = (int) sum; // 原二维数组有效数据总个数
        // 临时变量，存储稀疏数组的行号
        AtomicInteger inc = new AtomicInteger(0);
        IntStream.range(0, 8).forEach(i -> {
            IntStream.range(0, 8).filter(j -> array1[i][j] != 0).forEach(j -> {
                int index = inc.incrementAndGet();
                sparseArray[index][0] = i;
                sparseArray[index][1] = j;
                sparseArray[index][2] = array1[i][j];
            });
        });

        System.out.println("输出转化后的稀疏数组~~");
        for (int[] row : sparseArray) {
            for (int cel : row) {
                System.out.printf("%d\t", cel);
            }
            System.out.println();
        }

        System.out.println("稀疏数组转化为原数组~~~");
        int row = sparseArray[0][0]; // 原数组行数
        int cel = sparseArray[0][1]; // 原数组列数
        int total = sparseArray[0][2]; // 原数组有效数据个数，稀疏数组行数 - 1

        int[][] array2 = new int[row][cel];
        // 由于稀疏数组第一行为描述原数组信息，所以稀疏数组行数比原数据的有效数据数量 + 1
        IntStream.range(1, total+1).forEach(i -> {
            array2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        });

        for (int[] r: array2) {
            for (int c: r) {
                System.out.printf("%d\t", c);
            }
            System.out.println();
        }




    }
}
