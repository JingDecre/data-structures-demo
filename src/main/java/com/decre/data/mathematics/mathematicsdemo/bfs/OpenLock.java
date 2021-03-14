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
        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        int step1 = openLock(deadEnds, "0000", "3102");
        int step2 = doubleDirOpenLock(deadEnds, "0000", "3102");
        System.out.println();
        System.out.println("单向解锁的最小次数为：" + step1);
        System.out.println("双向解锁的最小次数为：" + step2);

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
        // 缓存需要遍历的密码组合，即取即删
        Queue<String> queue = new LinkedList<>();
        // 已经遍历过的密码集合，减少重复遍历
        Set<String> visited = new HashSet<>();
        // 初始化步数
        int step = 0;
        // 填充初始化数据
        queue.offer(start);
        // 密码长度，后续查找下一次密码校验使用
        int passwordLength = target.length();
        String temp;
        String temp2;
        // 对队列进行遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j <size; j++) {
                temp = queue.poll();
                // 死亡组合包含时跳过
                if (deadEnds.contains(temp)) {
                    continue;
                }
                // 命中目标，返回结果
                if (target.equals(temp)) {
                    return step;
                }
                for (int i = 0; i < passwordLength; i++) {
                    temp2 = plusOne(temp, i);
                    if (!visited.contains(temp2)) {
                        queue.offer(temp2);
                    }
                    temp2 = minusOne(temp, i);
                    if (!visited.contains(temp2)) {
                        queue.offer(temp2);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 计算从起点到终点，获取最短解锁的数字拨动路径
     *
     * @param deadEnds
     * @param start
     * @param target
     * @return
     */
    private static int doubleDirOpenLock(Set<String> deadEnds, String start, String target) {
        Set<String> startQueue = new HashSet<>();
        Set<String> endQueue = new HashSet<>();
        Set<String> visited = new HashSet<>();
        // 将起点加入队列
        int step = 0;
        int passwordLength = target.length();
        String temp;
        startQueue.add(start);
        endQueue.add(target);
        Set<String> tempSet;
        while (!startQueue.isEmpty() && !endQueue.isEmpty()) {
            tempSet = new HashSet<>();
            for (String password: startQueue) {
                // 跳过死亡节点
                if (deadEnds.contains(password)) {
                    continue;
                }
                // 命中目标节点
                if(endQueue.contains(password)) {
                    return step;
                }
                visited.add(password);
                // 遍历temp的所有临近的密码组合选择
                for (int j = 0; j < passwordLength; j++) {
                    temp = plusOne(password, j);
                    // 将已经尝试过的组合进行跳过
                    if (!visited.contains(temp)) {
                        tempSet.add(temp);
                    }
                    temp = minusOne(password, j);
                    if (!visited.contains(temp)) {
                        tempSet.add(temp);
                    }
                }
            }
            // 步数+1
            step++;
            // tempSet相当于q1
            // 交换startQueue endQueue， 下一轮while 就是扩散 endQueue
            startQueue = endQueue;
            endQueue = tempSet;
        }

        return -1;
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
