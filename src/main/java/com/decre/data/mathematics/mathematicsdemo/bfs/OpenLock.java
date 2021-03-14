package com.decre.data.mathematics.mathematicsdemo.bfs;

import java.util.*;

/**
 * @className: OpenLock
 * @description: 打开转盘锁，求最小解锁次数
 * @author: decre
 * @date: 2021-3-14 16:16
 **/
public class OpenLock {

    public static void main(String[] args) {
        Set<String> deadEnds = new HashSet<>();
        deadEnds.add("0201");
        deadEnds.add("0101");
        deadEnds.add("0102");
        deadEnds.add("1212");
        int step = openLock(deadEnds, "0000", "0109");
        System.out.println();
        System.out.println("解锁的最小次数为：" + step);

    }

    /**
     * 计算从起点到终点，获取最短解锁的数字拨动路径
     *
     * @param deadEnds
     * @param start
     * @param target
     * @return
     */
    private static int openLock(Set<String> deadEnds, String start, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        // 将起点加入队列
        queue.offer(start);
        visited.add(start);
        int step = 0;
        int passwordLength = target.length();
        String temp;
        String temp2;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 从队列中获取节点
                temp = queue.poll();
                // 命中目标节点
                if(target.equals(temp)) {
                    return step;
                }
                // 遍历temp的所有临近的密码组合选择
                for (int j = 0; j < passwordLength; j++) {
                    temp2 = plusOne(temp, j);
                    // 将密码组合在死亡组合里面以及已经尝试过的组合进行跳过
                    if (!deadEnds.contains(temp2) && !visited.contains(temp2)) {
                        queue.offer(temp2);
                        visited.add(temp2);
                    }
                    temp2 = minusOne(temp, j);
                    if (!deadEnds.contains(temp2) && !visited.contains(temp2)) {
                        queue.offer(temp2);
                        visited.add(temp2);
                    }
                }
            }
            // 步数+1
            step++;
        }

        return step;
    }

    /**
     * 将s的第j为字符向上拨动一次
     *
     * @param s
     * @param j
     * @return
     */
    private static String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j]++;
        }
        return new String(chars);
    }

    /**
     * 将s的第j为字符向下拨动一次
     *
     * @param s
     * @param j
     * @return
     */
    private static String minusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j]--;
        }
        return new String(chars);
    }
}
