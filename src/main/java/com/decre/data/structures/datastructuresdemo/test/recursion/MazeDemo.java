package com.decre.data.structures.datastructuresdemo.test.recursion;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @className: Maze
 * @description: 递归方式
 * @author: decre
 * @date: 2021/1/26
 **/
public class MazeDemo {

    public static void main(String[] args) {
        int[][] map = new int[8][7];
        // 使用1表示墙
        IntStream.range(0, 7).forEach(i -> {
            map[0][i] = 1;
            map[7][i] = 1;
        });
        // 左右全部置为1
        IntStream.range(0, 8).forEach(i -> {
            map[i][0] = 1;
            map[i][6] = 1;
        });

        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        Arrays.stream(map).forEach(sunArray -> {
            Arrays.stream(sunArray).forEach(i -> {
                System.out.printf(i + " ");
            });
            System.out.println();
        });
        // 开始按照既定策略走迷宫
        setWay(map, 1, 1);

        // 输出新的地图
        Arrays.stream(map).forEach(sunArray -> {
            Arrays.stream(sunArray).forEach(i -> {
                System.out.printf(i + " ");
            });
            System.out.println();
        });
    }


    /**
     * 策略 下->右->上->左，如果该点走不通，就回溯
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路，就返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已找到返回true
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2; // 假设改点可以走通
                if (setWay(map, i+1, j)) { // 往下走
                    return true;
                } else if (setWay(map, i, j+1)) {// 往右走
                    return true;
                } else if (setWay(map, i - 1, j)) { // 往上走
                    return true;
                } else if (setWay(map, i, j -1)) { // 往左走
                    return true;
                } else { // 说明改点走不通
                    map[i][j] = 3;
                    return false;
                }

            } else { // 可能是1，2，3
                return false;
            }
        }
    }
}
